import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class EC2Ejercicio2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List <Integer> numeros = new ArrayList<>();

        numeros.add(5);
        numeros.add(8);
        numeros.add(6);
        numeros.add(3);
        numeros.add(4);
        mostrarnumeros(numeros);


        System.out.println("ingrese ultimo  numero del arreglo: ");

        numeros.add(scan.nextInt());
        scan.nextLine();

        System.out.println("ingrese primer numero del arreglo: ");
        numeros.add(0,scan.nextInt());

        mostrarnumeros(numeros);



    }

    private static void mostrarnumeros(List numeros) {
        for (int i = 0; i< numeros.size();i++){
            System.out.println(numeros.get(i));
        }
    }
}
