import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Main {

    public static void main(String[] args) {

        Set<Empleado> Empleados = new HashSet<Empleado>();
        Map<Integer,Integer > Sueldos = new HashMap<>();

        Empleados.add(new Empleado("Alberto",36847546,8,150 ));
        Empleados.add(new Empleado("Juan",56214268,9,100));
        Empleados.add(new Empleado("Luana", 32962456, 6,200));
        Empleados.add(new Empleado("Pablo", 35894214,5,350));


        for (Empleado e : Empleados){

            Sueldos.put(e.DNI,e.HorasTrabajadas * e.ValorXHora);
            System.out.println(Sueldos);
        }


    }
}
