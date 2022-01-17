package es.joseluisgs.dam;

import es.joseluisgs.dam.models.Alumno;
import es.joseluisgs.dam.models.Clase;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Clase clase = new Clase("Programación", 1);

//        for (int i = 0; i < clase.getAlumnos().length; i++) {
//            System.out.println(clase.getAlumnos()[i].toString());
//        }
        Alumno a1 = new Alumno("Pepe", 20, 7.8f);
        clase.createAlumno(a1, 0);
        Alumno a2 = new Alumno("Ana", 22, 9.9f);
        clase.createAlumno(a2);

        System.out.println(clase.readAll());

        try {
            System.out.println("Alumano/a: " + clase.read(0));

            System.out.println("Alumano/a: " + clase.read(31));

            System.out.println("Alumano/a: " + clase.read(5));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
