import java.util.*;

public class Main {

    public static void main(String[] args) {
        String direccion = "listado.txt";
        Archivo a = new Archivo();
        List<Empleado> ListaEmpleados = a.LeerArchivo(direccion);

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese letra por la que desea Buscar: ");
        String letra = s.nextLine();
        System.out.println("Empleados con " + a);
        for (Empleado e: EmpleadosUtil.PorLetra(ListaEmpleados, letra)) {
            System.out.println(e);
        }

        System.out.println("\nEmpleado más viejo y empleado más joven.");
        Map<String, Empleado> Edades = EmpleadosUtil.PorEdad(ListaEmpleados);
        Edades.forEach((k,v) -> System.out.println(k +
                ":\nEmpleado: " + v.getNombre() + " " + v.getApellido() +
                " - Edad: " + v.getEdad()));

        System.out.println("\nEmpleado con mejor y peor salario.");
        Map<String, Empleado> MejorSalario = EmpleadosUtil.PorSueldo(ListaEmpleados);
        MejorSalario.forEach((k,v) -> System.out.println(k +
                ":\nEmpleado: " + v.getNombre() + " " + v.getApellido() +
                " - Salario: " + v.getSueldo()));

        System.out.println("\nLista de empleados ordenados alfabeticamente por nombre y apellido.)");
        for (Empleado e: EmpleadosUtil.porApellido(ListaEmpleados)) {
            System.out.println(e);
        }
    }
}
