package es.joseluisgs.dam;

import es.joseluisgs.dam.creators.AlumnoCreator;
import es.joseluisgs.dam.models.Alumno;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AlumnoCreator ac = new AlumnoCreator();
        // Directamente
        Alumno a1 = new Alumno("Pepe", 20, 8.25f);
        System.out.println(a1);
        // Con constructor
        Alumno a2 = ac.createFromTerminal();
        System.out.println(a2);
        Alumno a3 = ac.createRandom();
        System.out.println(a3);

    }
}
