package es.joseluisgs.dam;

import es.joseluisgs.dam.model.Alumno;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Alumno alumno = new Alumno("Pepe", 20, 8.25f);
        System.out.println(alumno.getNombre());
        System.out.println(alumno.getEdad());
        System.out.println(alumno.getNota());
        System.out.println(alumno.getCalificacion());
        System.out.println(alumno);
    }
}
