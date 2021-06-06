import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Baraja {
    int Numero;


    public Baraja(int j) {
        Numero = this.Numero;
        //Basto = this.Basto;
    }
    public Baraja() {

    }


    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        this.Numero = numero;
    }

    public String Basto(int i) {
        String basto[] = {"Treboles","Diamantes","Corazones", "Picas"};//Me hubiera gustado hacerlo ccon enum pero pense que no me daria el tiempo

        return basto[i];
    }

    public void mezclar_baraja(List Baraja) {

        Random random = new Random();
        Random randomb = new Random();
        for (int i = 0; i<4 ; i++){
            List <Integer> RandomB = Baraja;

            while (RandomB.size() > 1) {

                int randomIndex = random.nextInt(Baraja.size());
                int ranbombasto = randomb.nextInt(3);
                System.out.printf("%s %s%n", RandomB.get(randomIndex), Basto(ranbombasto));

                RandomB.remove(randomIndex);
            }
        }
    }

    public List<Integer> Cargar_mazo(){

        List <Integer> mazo = new ArrayList<>();
       for (int i = 2; i < 11; i++){

                mazo.add(i);
        }


        return mazo;
    }

    public List Dar_Vuelta(List Baraja){

        Collections.reverse(Baraja);


        return Baraja;
    }

    public void Imprimir(List <Integer> mazo){
        for (int i =0; i<mazo.size(); i ++){
            for (int j = 0; j < 4; j++) {
                System.out.println(mazo.get(i) + Basto(j));
            }
        }

    }


}
