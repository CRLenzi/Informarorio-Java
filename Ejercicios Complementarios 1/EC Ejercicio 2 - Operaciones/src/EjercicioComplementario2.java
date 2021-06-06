import java.util.Scanner;

public class EjercicioComplementario2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = a + b ;
        System.out.println(a + " + " + b + " = " + c);
        c = a - b;
        System.out.println(a + " - " + b + " = " + c);
        System.out.println(a + " * " + b + " = " + a*b);
        System.out.println(a + " / " + b + " = " + a/b);
        System.out.println(a + " % " + b + " = " + a%b);
    }
}
