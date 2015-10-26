package miw.dasm.inigo.gestorpilotos;

public class Piloto {
    private int _id;
    private String _nombre;
    private int _dorsal;
    private String _moto;
    private boolean _activo;

    public Piloto(int id, String nombre, int dorsal, String moto, boolean activo) {
        this._id = id;
        this._nombre = nombre;
        this._dorsal = dorsal;
        this._moto = moto;
        this._activo = activo;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int id) {
        this._id = id;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String nombre) {
        this._nombre = nombre;
    }

    public int get_dorsal() {
        return _dorsal;
    }

    public void set_dorsal(int dorsal) {
        this._dorsal = dorsal;
    }

    public String get_moto() {
        return _moto;
    }

    public void set_moto(String moto) {
        this._moto = moto;
    }

    public boolean is_activo() {
        return _activo;
    }

    public void set_activo(boolean activo) {
        this._activo = activo;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "_id=" + _id +
                ", _nombre='" + _nombre + '\'' +
                ", _dorsal=" + _dorsal +
                ", _moto='" + _moto + '\'' +
                ", _activo=" + _activo +
                '}';
    }
}
