package com.company;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
        List<String> Palabras = new ArrayList<>();
        Palabras.add("Hola");
        Palabras.add(null);
        Palabras.add("Informatorio");
        Palabras.add("");
        List<String> Lista = Palabras.stream()
                .filter(Objects::nonNull)
                .filter(p -> !p.equals(""))
                .collect(Collectors.toList());
        System.out.println(Lista);
    }
}
