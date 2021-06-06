import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> Horas_Trabajadas = new ArrayList<>();
        List <Integer> PrecioXHora = new ArrayList<>();
        List<Integer> TotalesXDia = new ArrayList<>();
        double TOTAL = 0;
        Horas_Trabajadas.add(6);//Lunes
        Horas_Trabajadas.add(7);//Martes
        Horas_Trabajadas.add(4);//Miercoles
        Horas_Trabajadas.add(8);//Jueves
        Horas_Trabajadas.add(9);//Viernes

        PrecioXHora.add(485);//Lunes
        PrecioXHora.add(300);//Martes
        PrecioXHora.add(250);//Miercoles
        PrecioXHora.add(100);//Jueves
        PrecioXHora.add(325);//Viernes

        for (int i = 1; i<=Horas_Trabajadas.size();i++){
            System.out.println("El Dia " + i + " trabajo " + Horas_Trabajadas.get(i-1) + " con un valor de " + PrecioXHora.get(i-1) + " por hora");
            TotalesXDia.add(Horas_Trabajadas.get(i-1)*PrecioXHora.get(i-1));
            System.out.println("Por el Dia " + i + " debería cobra: " + TotalesXDia.get(i-1));
            TOTAL = TOTAL + TotalesXDia.get(i-1);
            System.out.println(" ");
        }

        System.out.println(" ");
        System.out.println("El Pago del cobro por la semana laboral es de : " + TOTAL);

    }
}
