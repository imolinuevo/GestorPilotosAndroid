package miw.dasm.inigo.gestorpilotos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ActividadPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_actividad_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    protected void onStart() {
        super.onStart();
        AlmacenPilotos almacenPilotos = new AlmacenPilotos(getApplicationContext());
        /*
        almacenPilotos.add(new Piloto(1, "p1", 1, "Derbi", true));
        almacenPilotos.add(new Piloto(2, "p2", 2, "Honda", true));
        almacenPilotos.add(new Piloto(3, "p3", 3, "Yamaha", true));
        */
        List<Piloto> values = almacenPilotos.getAll();
        PilotoAdapter adapter = new PilotoAdapter(this, android.R.layout.simple_spinner_dropdown_item, values);
        ListView listaPilotos = (ListView) findViewById(R.id.listaPilotos);
        listaPilotos.setAdapter(adapter);
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

    public void borrarContenido() {
        AlmacenPilotos almacenPilotos = new AlmacenPilotos(getApplicationContext());
        almacenPilotos.emptyAll();
        List<Piloto> values = almacenPilotos.getAll();
        PilotoAdapter adapter = new PilotoAdapter(this, android.R.layout.simple_spinner_dropdown_item, values);
        ListView listaPilotos = (ListView) findViewById(R.id.listaPilotos);
        listaPilotos.setAdapter(adapter);
    }
}
