public class Empleado {

    String Nombre;
    int DNI;
    int HorasTrabajadas;
    int ValorXHora;


    public Empleado (String Nombre, int DNI, int HorasTrabajadas,int ValorXHoras){
        Nombre = this.Nombre;
        DNI = this.DNI;
        HorasTrabajadas= this.HorasTrabajadas;
        ValorXHoras = this.ValorXHora;
    }


    public String getNombre() {
        return Nombre;
    }

    public int getDNI() {
        return DNI;
    }

    @Override
    public String toString() {
        return "Empleado " + Nombre + " DNI: " + DNI + " trabajo " + HorasTrabajadas + " horas con un valor de: " + ValorXHora + "\n\n";
    }
}
