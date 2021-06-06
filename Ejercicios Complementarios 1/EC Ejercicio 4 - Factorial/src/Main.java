import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int f=1;
        for (int i = 1; i<= a; i++){
            f=f*i;
        }

        System.out.println("El factorial de " + a + " es: " + f);
    }
}
