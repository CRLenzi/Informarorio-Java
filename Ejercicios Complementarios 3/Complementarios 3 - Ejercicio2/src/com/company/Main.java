package com.company;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> Base = List.of(1, 2, 3, 4, 5);
        Integer Exponente  = 2;
        List<Integer> ListaResultados = Base.stream()
                .map(p-> Main.Potencia(p, Exponente))
                .collect(Collectors.toList());
        System.out.println(ListaResultados);
    }

    public static Integer Potencia (Integer num, Integer exp) {
        if (exp == 0){
            return 1;
        }else {
            return num * Potencia(num, exp-1);
        }
    }

}
