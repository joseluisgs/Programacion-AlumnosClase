package es.joseluisgs.dam;

import es.joseluisgs.dam.models.Alumno;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Alumno a1 = new Alumno("Pepe", 25, 7.5f);
        System.out.println(a1);
        Alumno a2 = new Alumno("Pepe", 25, 7.5f);
        System.out.println(a2);
        Alumno a3 = a2;

        // Dos objetos pueden ser iguales  o identicos

        // La igualdad se hace en base al estado. No se usa el ==. Usamos equals
        // Dos objetos son identicos si tienen la misma referencia, es decir
        // Es el mismo objeto en memoria. Usamos el ==
        System.out.println("¿Iguales a1 y a2 con == --> falso");
        if (a1 == a2) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales. Son objetos distintos con el mismo estado");
        }

        System.out.println("¿Identicos a2 y a3 con == --> true");
        if (a2 == a3) {
            System.out.println("Son iguales. Tienen la misma referencia");
        } else {
            System.out.println("No son iguales");
        }

        System.out.println("¿Iguales a1 y a2 con equals --> true");
        if (a1.equals(a2)) {
            System.out.println("Son iguales. Tiene el mismo estado");
        } else {
            System.out.println("No son iguales");
        }


    }
}
