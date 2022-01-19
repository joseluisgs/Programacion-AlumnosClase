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
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            System.out.println("Alumano/a: " + clase.read(31));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            System.out.println("Alumano/a: " + clase.read(5));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        Alumno a4 = clase.readOrNull(45);
//        if (a4 != null) {
//            System.out.println("Alumano/a: " + a4);
//        } else {
//            System.out.println("No existe el alumno/a");
//        }

        Alumno a4 = clase.readOrNull(1);
        if (a4 != null) {
            System.out.println("Alumano/a: " + a4);
        } else {
            System.out.println("No existe el alumno/a");
        }


        Alumno a3 = new Alumno("Juan", 25, 8.5f);
        clase.update(a3, 0);

        System.out.println(clase.readAll());

        clase.delete(0);

        System.out.println(clase.readAll());

        clase.initRandom();
        System.out.println("Listado de Alumnos/as:");
        System.out.println(clase.readAll());
        System.out.println();
        System.out.println("Número de Aprobados/as: " + clase.getNumeroAprobados() + " - " + clase.percentAprobados() + "%");
        System.out.println();
        System.out.println("Alumnos Aprobados/as: \n" + clase.getListaAprobados());
        System.out.println();
        System.out.println("Número de Suspensos: " + clase.getNumeroSuspensos() + " - " + clase.percentSuspensos() + "%");
        System.out.println();
        System.out.println("Alumnos Suspensos/as: \n" + clase.getListaSuspensos());
        System.out.println();
        System.out.println("Nota Media: " + clase.getNotaMedia());
        System.out.println();
        System.out.println("Alumnos con Notable: \n" + clase.findByCalificacion("Notable"));
        System.out.println();
        System.out.println("Alumnos que se llaman Pepe: \n" + clase.findByNombre("Pepe"));
        System.out.println();
        clase.orderByNotaDesc();
        System.out.println("Alumnos ordenados por nota DESC:");
        System.out.println(clase.readAll());
        System.out.println();
        clase.orderByNotaAsc();
        System.out.println("Alumnos ordenados por nota ASC:");
        System.out.println(clase.readAll());
        System.out.println();
        clase.orderByNombreAsc();
        System.out.println("Alumnos ordenados por nombre ASC:");
        System.out.println(clase.readAll());
        System.out.println();
        clase.orderByNombreDesc();
        System.out.println("Alumnos ordenados por nombre DESC:");
        System.out.println(clase.readAll());
        System.out.println();
        clase.orderByNombreDesc();
        System.out.println("Alumnos ordenados por nombre DESC:");
        System.out.println(clase.readAll());
        System.out.println();
        clase.orderByNotaQuickSort();
        System.out.println("Alumnos ordenados por QuickSort:");
        System.out.println(clase.readAll());
        System.out.println();
    }
}
