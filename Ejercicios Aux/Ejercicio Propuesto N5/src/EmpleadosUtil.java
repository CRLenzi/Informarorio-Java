
import java.util.*;

public abstract class EmpleadosUtil {

        public static List<Empleado> PorLetra(List<Empleado> empleados, String letter) {
            List<Empleado> ListaEmpleados = new ArrayList<>();
            for (Empleado emp : empleados) {
                if (letter.equalsIgnoreCase(String.valueOf(emp.getApellido().charAt(0))))
                    ListaEmpleados.add(emp);
            }

            return ListaEmpleados;
        }

        public static Map<String, Empleado> PorEdad(List<Empleado> ListaEmpleados) {
            Map<String, Empleado> emp = new HashMap<>();
            ListaEmpleados.sort(Comparator.comparing(Empleado::getEdad));

            emp.put("Joven", ListaEmpleados.get(0));
            emp.put("Viejo", ListaEmpleados.get(ListaEmpleados.size() - 1));
            return emp;
        }

        public static Map<String, Empleado> PorSueldo(List<Empleado> ListaEmpleados) {
            Map<String, Empleado> emp = new HashMap<>();
            ListaEmpleados.sort(Comparator.comparing(Empleado::getSueldo));

            emp.put("Poor", ListaEmpleados.get(0));
            emp.put("Best", ListaEmpleados.get(ListaEmpleados.size() - 1));
            return emp;
        }

        public static List<Empleado> porApellido(List<Empleado> ListaEmpleados) {
            ListaEmpleados.sort(Comparator.comparing(Empleado::getNombre).thenComparing(Empleado::getApellido));
            return ListaEmpleados;
        }
    }

