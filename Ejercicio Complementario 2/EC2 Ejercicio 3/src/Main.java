import java.util.ArrayList;
import java.util.List;

//se advierte que el mazo solo da la ilucion de un basto, ya que no quise utilizar enumeración para definirlo y armarlo como lista de objetos
public class Main {

    public static void main(String[] args) {

        List<Integer> mazo;
        mazo = new ArrayList<>();
        Baraja b = new Baraja();
        System.out.println("Cargar Mazo: ");
        mazo = b.Cargar_mazo();
        b.Imprimir(mazo);

        System.out.println("///////////////////////////////////////////");
        System.out.println(" ");
        System.out.println("Dar vuelta el mazo: ");

        b.Dar_Vuelta(mazo);
        b.Imprimir(mazo);

        System.out.println("///////////////////////////////////////////");
        System.out.println(" ");
        System.out.println("Se Mezclan 10 cartas: ");
        b.mezclar_baraja(mazo);

        //se advierte que el mazo solo da la ilucion de un basto, ya que no quise utilizar enumeración para definirlo y armarlo como lista de objetos


    }


}

