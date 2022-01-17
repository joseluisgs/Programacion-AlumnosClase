package es.joseluisgs.dam.creators;

import es.joseluisgs.dam.models.Alumno;
import es.joseluisgs.dam.utils.Input;

public class AlumnoCreator {
    /**
     * Crea un alumno leyendo los datos por consola
     */
    public Alumno createFromTerminal() {
        // Leemos el nombre
        String nombre = leerNombre();
        // Leemos la edad
        int edad = leerEdad();
        // leemos la nota
        float nota = leerNota();
        // Creamos el alumno
        Alumno alumno = new Alumno(nombre, edad, nota);
        // Devolvemos el alumno
        return alumno;
    }

    /**
     * Crea alumnos con datos aleatorios para automatizar
     */
    public Alumno createRandom() {
        // Leemos el nombre
        String nombre = nombreRandom();
        // Leemos la edad
        int edad = edadRandom();
        // leemos la nota
        float nota = notaRandom();
        // Creamos el alumno
        Alumno alumno = new Alumno(nombre, edad, nota);
        // Devolvemos el alumno
        return alumno;
    }

    /**
     * Genera un nombre aleatorio
     *
     * @return nombre aleatorio
     */
    private String nombreRandom() {
        String[] lista = {"Pepe", "Juan", "Maria", "Jose", "Luis", "Ana", "Antonio", "Manuel", "Javier", "Sara", "Laura", "Sergio", "Jorge", "Rosa"};
        int pos = (int) (Math.random() * lista.length);
        return lista[pos];
    }

    /**
     * Genera una edad aleatoria
     *
     * @return edad aleatoria
     */
    private int edadRandom() {
        return (int) (Math.random() * 99 + 1);
    }

    /**
     * Genera una nota aleatoria
     *
     * @return nota aleatoria
     */
    private float notaRandom() {
        return (float) (Math.random() * 10);
    }

    /**
     * Lee un nombre por consola. con longitud 1 a 99
     */
    private String leerNombre() {
        Input input = new Input();
        boolean ok = false;
        String nombre = "";
        do {
            System.out.println("Introduce el nombre del alumno/a: ");
            nombre = input.readLine();
            if (nombre.length() == 0 || nombre.length() >= 100) {
                System.out.println("El nombre debe tener entre 1 y 99 caracteres");
            } else {
                ok = true;
            }
        } while (!ok);
        return nombre;
    }

    /**
     * Lee una edad por consola entre 1 y 99
     */
    private int leerEdad() {
        Input input = new Input();
        boolean ok = false;
        int edad = -1;
        do {
            System.out.println("Introduce la edad del alumno/a: ");
            edad = input.readInt();
            if (edad <= 0 || edad >= 100) {
                System.out.println("La edad debe estar entre 1 y 99");
            } else {
                ok = true;
            }
        } while (!ok);
        return edad;
    }

    /**
     * Lee una nota por consola entre 0 y 10
     */
    private float leerNota() {
        Input input = new Input();
        boolean ok = false;
        float nota = 0;
        do {
            System.out.println("Introduce la nota del alumno/a: ");
            nota = input.readFloat();
            if (nota < 0 || nota > 10) {
                System.out.println("La nota debe estar entre 0 y 10");
            } else {
                ok = true;
            }
        } while (!ok);
        return nota;
    }
}
