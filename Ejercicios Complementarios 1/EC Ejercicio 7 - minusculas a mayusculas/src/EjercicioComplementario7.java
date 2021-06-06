import java.util.Scanner;

public class EjercicioComplementario7 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char [] minusculas = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
        char [] mayusculas = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        String texto = scan.nextLine();
        scan.close();

        char [] texnvo = new char[texto.length()];

        for (int i = 0; i < texto.length(); i++){
            for(int j = 0; j < minusculas.length; j++){
                if(texto.charAt(i)== minusculas[j]){
                    texnvo[i] = mayusculas[j];
                }
            }
        }

        for (int i = 0; i < texnvo.length; i++){
            System.out.print(texnvo[i]);
        }

    }
}
