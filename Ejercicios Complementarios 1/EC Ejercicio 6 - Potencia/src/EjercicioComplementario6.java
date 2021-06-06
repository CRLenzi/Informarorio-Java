import java.util.Scanner;

public class EjercicioComplementario6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int r = 1;
        for (int i = 1; i<= b; i++){
            r = r * a;
        }
        System.out.println(a + " elevado a la " + b + " = " + r);
    }
}
