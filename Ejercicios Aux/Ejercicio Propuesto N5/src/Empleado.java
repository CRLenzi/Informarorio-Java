import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Empleado {


    String Nombre;
    String Apellido;
    Date FecNac;
    Double Sueldo;
    int Edad;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, Date fecNac, Double sueldo) {
        Nombre = nombre;
        Apellido = apellido;
        FecNac = fecNac;
        Sueldo = sueldo;
    }
    public LocalDate getEdad() {
        Calendar fecha = new GregorianCalendar();
        return (LocalDate) LocalDate.parse((CharSequence) FecNac, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Date getFecNac() {
        return FecNac;
    }

    public void setFecNac(Date fecNac) {
        FecNac = fecNac;
    }

    public Double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(Double sueldo) {
        Sueldo = sueldo;
    }
}
