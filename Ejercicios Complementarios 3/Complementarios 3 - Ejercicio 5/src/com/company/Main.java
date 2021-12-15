package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Alumno> alumnos = List.of(new Alumno("Homero", "Simpson", LocalDate.now().minusYears(30)),
                new Alumno("Bart", "Simpson", LocalDate.of(1999, 1, 10)),
                new Alumno("Lisa", "Simpson", LocalDate.of(1998, 2, 11)),
                new Alumno("Marge", "Simpson", LocalDate.of(1997, 3, 12)),
                new Alumno("Maggie", "Simpson", LocalDate.of(1996, 4, 13)));
        Map<String,Integer> edad = alumnos.stream()
                .collect(Collectors.toMap(p-> (p.getName() + " " + p.getSurname()),
                        p -> Main.getEdad(p.getBirthday())));
        System.out.print(edad);
    }
    public static Integer getEdad(LocalDate birthDate){
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}