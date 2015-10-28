package miw.dasm.inigo.gestorpilotos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class DetallePilotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_piloto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getBundleExtra("bundle");
        TextView nombreText = (TextView) findViewById(R.id.nombreText);
        nombreText.setText("Nombre: " + bundle.getString("_nombre"));
        TextView dorsalText = (TextView) findViewById(R.id.dorsalText);
        dorsalText.setText("Dorsal: " + bundle.getInt("_dorsal"));
        TextView motoText = (TextView) findViewById(R.id.motoText);
        motoText.setText("Moto: " + bundle.getString("_moto"));
        CheckBox activoCheck = (CheckBox) findViewById(R.id.activoCheck);
        activoCheck.setChecked(bundle.getBoolean("_activo"));
        activoCheck.setText("Estado");
    }
}
