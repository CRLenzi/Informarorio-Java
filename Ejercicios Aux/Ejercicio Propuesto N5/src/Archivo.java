
import com.sun.corba.se.spi.orb.ParserData;

import java.io.*;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import  java.util.List;


public class Archivo {

    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    Empleado persona = new Empleado();

    public List LeerArchivo(String arc) {
        List<Empleado> listado = new ArrayList<>();
        try {
            // Apertura del fichero y creacion de BufferedReader
            archivo = new File(arc);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            // Lectura del fichero
            String linea;
            String[] datos = new String[0];
            while ((linea = br.readLine()) != null) {
                datos = linea.split(",");
                persona.setNombre(datos[0]);
                persona.setApellido(datos[1]);
                persona.setFecNac(formato.parse(datos[2]));
                persona.setSueldo(Double.parseDouble(datos[3]));
                listado.add(persona);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return listado;
    }

}
