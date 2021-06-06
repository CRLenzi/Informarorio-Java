import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {


    public static void main(String[] args) throws IOException {

        ListarAlumnos("Alumnos.txt");
    }
    public static void ListarAlumnos(String archivo) throws FileNotFoundException, IOException {
        String alum;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((alum = b.readLine())!=null) {
            System.out.println(alum);
        }
        b.close();
    }


}
