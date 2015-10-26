package miw.dasm.inigo.gestorpilotos;

public class Piloto {
    private int id;
    private String nombre;
    private int dorsal;
    private String moto;
    private boolean activo;

    public Piloto(int id, String nombre, int dorsal, String moto, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.moto = moto;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getMoto() {
        return moto;
    }

    public void setMoto(String moto) {
        this.moto = moto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
