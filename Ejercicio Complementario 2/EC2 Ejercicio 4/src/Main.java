import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args) {

        List <String> Alumnos = new ArrayList<>();

        Alumnos.add("Joaquin");
        Alumnos.add("Alan");
        Alumnos.add("Esteban");
        Alumnos.add("Maria");
        Alumnos.add("Juan");
        Alumnos.add("Juana");

        for (int i = 0; i<Alumnos.size();i++ ){
            System.out.println(Alumnos.get(i));
        }

        List <String> Curso1 = Alumnos.subList(0,2);
        List <String> Curso2 = Alumnos.subList(2,4);
        List <String> Curso3 = Alumnos.subList(4,6);

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Alumnos que pertenecen al curso 1: ");
        for (int i = 0; i<Curso1.size();i++ ){
            System.out.println(Curso1.get(i));
        }

        System.out.println(" ");
        System.out.println("Alumnos que pertenecen al curso 2: ");
        for (int i = 0; i<Curso2.size();i++ ){
            System.out.println(Curso2.get(i));
        }

        System.out.println(" ");
        System.out.println("Alumnos que pertenecen al curso 3: ");
        for (int i = 0; i<Curso3.size();i++ ){
            System.out.println(Curso3.get(i));
        }


    }
}
