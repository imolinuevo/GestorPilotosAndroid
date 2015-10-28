package miw.dasm.inigo.gestorpilotos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.ImageView;
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
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        try {
            new DownloadImageTask((ImageView)  imageView).execute("https://cdn2.iconfinder.com/data/icons/transport-5/236/transport-icons-04.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
