package miw.dasm.inigo.gestorpilotos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActividadPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_actividad_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    protected void onStart() {
        super.onStart();
        AlmacenPilotos almacenPilotos = new AlmacenPilotos(getApplicationContext());
        List<Piloto> values = almacenPilotos.getAll();
        PilotoAdapter adapter = new PilotoAdapter(this, android.R.layout.simple_spinner_dropdown_item, values);
        ListView listaPilotos = (ListView) findViewById(R.id.listaPilotos);
        listaPilotos.setAdapter(adapter);
        listaPilotos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("ItemOnclick", new Integer(position).toString());
                Log.d("ItemOnclick", parent.getItemAtPosition(position).toString());
                lanzarDetallePiloto((Piloto) parent.getItemAtPosition(position));
            }
        });
        Button button = (Button) findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPiloto();
            }
        });
    }

    public void lanzarDetallePiloto(Piloto piloto) {
        Intent detallePioto = new Intent(this, DetallePilotoActivity.class);
        startActivity(detallePioto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actividad_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.accionVaciar) {
            borrarContenido();
        }
        return super.onOptionsItemSelected(item);
    }

    public void addPiloto() {
        AlmacenPilotos almacenPilotos = new AlmacenPilotos(getApplicationContext());
        EditText editText = (EditText) findViewById(R.id.textViewAdd);
        String name = editText.getText().toString();
        int id = 0;
        List<Piloto> pilotos = almacenPilotos.getAll();
        if (pilotos.size() != 0) {
            id = pilotos.size();
        }
        id++;
        almacenPilotos.add(new Piloto(id, name, id, "Moto", false, "Foto"));
        List<Piloto> values = almacenPilotos.getAll();
        PilotoAdapter adapter = new PilotoAdapter(this, android.R.layout.simple_spinner_dropdown_item, values);
        ListView listaPilotos = (ListView) findViewById(R.id.listaPilotos);
        listaPilotos.setAdapter(adapter);
    }

    public void borrarContenido() {
        AlmacenPilotos almacenPilotos = new AlmacenPilotos(getApplicationContext());
        almacenPilotos.emptyAll();
        List<Piloto> values = almacenPilotos.getAll();
        PilotoAdapter adapter = new PilotoAdapter(this, android.R.layout.simple_spinner_dropdown_item, values);
        ListView listaPilotos = (ListView) findViewById(R.id.listaPilotos);
        listaPilotos.setAdapter(adapter);
    }
}
