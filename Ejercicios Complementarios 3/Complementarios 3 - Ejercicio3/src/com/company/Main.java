package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> palabras = List.of("Batman", "Aquaman", "Flash", "Batgirl", "Wonder Woman", "brainiac");

        long filtro = palabras.stream()
                .filter(p -> p.startsWith("B") || p.startsWith("b"))
                .count();

        System.out.print(filtro);
    }
}
