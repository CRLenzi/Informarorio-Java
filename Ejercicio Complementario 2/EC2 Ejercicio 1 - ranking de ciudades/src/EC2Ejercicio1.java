import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EC2Ejercicio1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List <String> ciudades = new ArrayList<>();

        for(int i = 1; i <4; i++){
            System.out.println("Ingrese ciudad: ");
            ciudades.add(scan.nextLine());

        }

        for(int i = 1; i <=ciudades.size(); i++){
            System.out.println("# " + i + " - " + ciudades.get(i-1));
        }

    }
}
