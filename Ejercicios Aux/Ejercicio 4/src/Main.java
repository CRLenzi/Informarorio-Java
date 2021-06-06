import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList <Empleado> emp = new ArrayList() {};

        emp.add(new Empleado("Carlos","D1","cuil1"));
        emp.add(new Empleado("Damian","D2","cuil2"));

        CargarEmplados(emp);
    }

    public static void  CargarEmplados(List empleados) {
        FileWriter fichero = null;
        PrintWriter pw = null; //Lo que escribiremos en el archivo
        try
        {
            fichero = new FileWriter("Em.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++)
                pw.println(empleados);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}


