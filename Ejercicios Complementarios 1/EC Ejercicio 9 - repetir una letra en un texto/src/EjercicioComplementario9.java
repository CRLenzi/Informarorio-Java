import java.util.Scanner;

public class EjercicioComplementario9 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingresar texto: ");
        String tex = scan.nextLine();
        System.out.println("ingrese la letra que desea contar: ");
        String letra = scan.nextLine();
        scan.close();
        int cont = 0 ;
        for (int i = 0; i < tex.length(); i++){
            if (tex.charAt(i)== letra.charAt(0)){
                cont++;
            }
        }

        System.out.println(cont);
    }
}
