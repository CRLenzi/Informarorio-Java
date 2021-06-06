import java.util.Scanner;

public class EjercicioComplementario8 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingresar su nombre y apellido: ");
        String nombre = scan.nextLine();
        System.out.println("Ingrese su edad: ");
        int edad = scan.nextInt();
        scan.nextLine();
        System.out.println("Ingrese su direccion: ");
        String direccion = scan.nextLine();
        System.out.println("Ingrese su ciudad: ");
        String ciudad = scan.nextLine();

        System.out.println(ciudad + " - " + direccion + " - " + edad + " - " + nombre );
    }
}
