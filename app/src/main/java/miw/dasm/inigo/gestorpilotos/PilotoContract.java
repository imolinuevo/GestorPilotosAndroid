package miw.dasm.inigo.gestorpilotos;

import android.provider.BaseColumns;

public abstract class PilotoContract {
    public static class TablaPiloto implements BaseColumns {
        public static final String TABLE_NAME = "Pilotos";
        public static final String COL_NAME_ID = "id";
        public static final String COL_NAME_NOMBRE = "nombre";
        public static final String COL_NAME_DORSAL = "dorsal";
        public static final String COL_NAME_MOTO = "moto";
        public static final String COL_NAME_ACTIVO = "activo";
    }
}
