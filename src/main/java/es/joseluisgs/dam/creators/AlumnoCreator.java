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
     * 20% 18 y 20    ---- 0 a 20
     * 30% entre 20 y 25 ---- 20 a 50
     * 40% entre 25 y 30 ----- 50 a 90
     * 10 % entre 30 y 40 ----- 90 a 100
     *
     * @return edad aleatoria
     */
    private int edadRandom() {
        int porcentaje = (int) (Math.random() * 100);
        // Min + (int)(Math.random() * ((Max - Min) + 1))
        if (porcentaje < 20) {
            return 18 + (int) (Math.random() * ((20 - 18) + 1));
        } else if (porcentaje < 50) {
            return 20 + (int) (Math.random() * ((25 - 20) + 1));
        } else if (porcentaje < 90) {
            return 25 + (int) (Math.random() * ((30 - 25) + 1));
        } else {
            return 30 + (int) (Math.random() * ((40 - 30) + 1));
        }
    }

    /**
     * Genera una nota aleatoria
     * 30% 1.0 a 4.99    ---- 0 a 30
     * 10% 5.00 y 5.99 ---- 30 a 40
     * 30% entre 6 y 6.99 ----- 40 a 70
     * 20% entre 7 y 8.99 ----- 70 a 90
     * 10 % entre 9 y 10 ----- 90 a 100
     *
     * @return nota aleatoria
     */
    private float notaRandom() {
        int porcentaje = (int) (Math.random() * 100);
        // Min + (int)(Math.random() * ((Max - Min) + 1))
        if (porcentaje < 30) {
            // Suspenso
            return (float) (1.0 + (Math.random() * (4.99 - 1.0)));
        } else if (porcentaje < 40) {
            // Suficiente
            return (float) (5.0 + (Math.random() * (5.99 - 5.0)));
        } else if (porcentaje < 70) {
            // Bien
            return (float) (6.0 + (Math.random() * (6.99 - 6.0)));
        } else if (porcentaje < 90) {
            // Notable
            return (float) (7.0 + (Math.random() * (8.99 - 7.0)));
        } else {
            // Sobresaliente
            return (float) (9.0 + (Math.random()));
        }
    }

    /**
     * Lee un nombre por consola. con longitud 1 a 99
     */
    private String leerNombre() {
        boolean ok = false;
        String nombre = "";
        do {
            System.out.println("Introduce el nombre del alumno/a: ");
            nombre = Input.readLine();
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
        boolean ok = false;
        int edad = -1;
        do {
            System.out.println("Introduce la edad del alumno/a: ");
            edad = Input.readInt();
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
        boolean ok = false;
        float nota = 0;
        do {
            System.out.println("Introduce la nota del alumno/a: ");
            nota = Input.readFloat();
            if (nota < 0 || nota > 10) {
                System.out.println("La nota debe estar entre 0 y 10");
            } else {
                ok = true;
            }
        } while (!ok);
        return nota;
    }
}
