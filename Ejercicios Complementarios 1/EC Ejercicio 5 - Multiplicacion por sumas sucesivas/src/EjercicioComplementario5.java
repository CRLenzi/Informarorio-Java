import java.util.Scanner;

public class EjercicioComplementario5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int r=0;
        for (int i = 1; i<=b; i++){
            r = r + a;
        }
        System.out.println( a + " X " + b + " = " + r);
    }
}
