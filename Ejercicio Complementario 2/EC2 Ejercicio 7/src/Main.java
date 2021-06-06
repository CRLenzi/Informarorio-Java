import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in);

        System.out.println("Ingrese el valor de inicio");
        int inicio = s1.nextInt();

        s1.nextLine();
        System.out.println("Ingrese el valor anterior final");
        int fin = s1.nextInt();

        List <String> resultado = Crear_Array(inicio,fin);

        for (int i = 0; i< resultado.size();i++){
            System.out.println(resultado.get(i));
        }

    }

    public static String Comparar(int i){
        if (i%2==0 && i%3==0) return "FizzBuzz";
        else if (i%3==0) return "Buzz";
        else if (i%2==0) return "Fizz";
        else return String.valueOf(i);
    }

    public static List Crear_Array(int inicio, int fin){
        List <String> k = new ArrayList<>();
        for (int i = inicio; i<fin; i++){
            k.add(Comparar(i));
        }
        return k;
    }
}
