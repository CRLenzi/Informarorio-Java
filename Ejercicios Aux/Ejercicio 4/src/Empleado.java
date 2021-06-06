
public class Empleado {
    private String Nombre;
    private String Direccion;
    private String CUIL;

    public Empleado(String Nombre, String d1reccion, String CUIL) {
        Nombre = this.Nombre;
        Direccion = this.Direccion;
        CUIL = this.CUIL;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getCUIL() {
        return CUIL;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setCUIL(String CUIL) {
        this.CUIL = CUIL;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    @Override
    public String toString() {
        return Nombre + " " + CUIL + " " + Direccion;
    }
}
