package miw.dasm.inigo.gestorpilotos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AlmacenPilotos extends SQLiteOpenHelper {

    private static final String DEFAULT_DATABASE_FILENAME = "pilotos.db";

    private static final int DATABASE_VERSION = 1;

    public AlmacenPilotos(Context context) {
        super(context, DEFAULT_DATABASE_FILENAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String consultaSQL = "CREATE TABLE " + PilotoContract.TablaPiloto.TABLE_NAME + " ("
                + PilotoContract.TablaPiloto.COL_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PilotoContract.TablaPiloto.COL_NAME_NOMBRE + " TEXT, "
                + PilotoContract.TablaPiloto.COL_NAME_DORSAL + " INTEGER, "
                + PilotoContract.TablaPiloto.COL_NAME_MOTO + " TEXT, "
                + PilotoContract.TablaPiloto.COL_NAME_ACTIVO + " INTEGER)";
        db.execSQL(consultaSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String consulta = "DROP TABLE " + PilotoContract.TablaPiloto.TABLE_NAME;
        db.execSQL(consulta);
        this.onCreate(db);
    }

    public int add(Piloto piloto) {
        int activo;
        if (piloto.is_activo()){
            activo = 1;
        } else {
            activo = 0;
        }
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(PilotoContract.TablaPiloto.COL_NAME_ID, piloto.get_id());
        valores.put(PilotoContract.TablaPiloto.COL_NAME_NOMBRE, piloto.get_nombre());
        valores.put(PilotoContract.TablaPiloto.COL_NAME_DORSAL, piloto.get_dorsal());
        valores.put(PilotoContract.TablaPiloto.COL_NAME_MOTO, piloto.get_moto());
        valores.put(PilotoContract.TablaPiloto.COL_NAME_ACTIVO, activo);
        return (int) db.insert(PilotoContract.TablaPiloto.TABLE_NAME, null, valores);
    }
}
