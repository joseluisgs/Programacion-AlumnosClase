package es.joseluisgs.dam.models;

/**
 * Clase que representa un alumno/a.
 */
public class Alumno {
    private String nombre = "";
    private int edad = 0;
    private float nota = 0.0f;
    private String calificacion = "";

    /**
     * Constructor de alumno.
     *
     * @param nombre Nombre del alumno.
     * @param edad   Edad del alumno.
     * @param nota   Nota del alumno.
     */
    public Alumno(String nombre, int edad, float nota) {
        // Lo normal, pero si no lo pongo, no se puede llamar al constructor con null o con datos incoherentes
        // que filtramos en los set... Así que lo comento.
        // this.nombre = nombre;
        // this.edad = edad;
        // this.nota = nota;
        setNombre(nombre);
        setEdad(edad);
        setNota(nota);
        calificacion = calcularCalificacion();
    }

    /** Getter and Setter */

    /**
     * Nombre del Alumno
     *
     * @return Nombre del Alumno
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set el nombre del alumno
     *
     * @param nombre Nombre del alumno. Hasta 100 caracteres (0-99). Si el nombre es null o vacio, lanza una excepcion
     */
    public void setNombre(String nombre) {
        if (nombre != null && nombre.trim().length() > 0 && nombre.trim().length() < 100) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre no puede estar vacío ni tener más de 100 caracteres");
        }
    }

    /**
     * Obtiene la edad del un alumno
     *
     * @return Edad del alumno
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Asigna la edad de un alumno
     *
     * @param edad Edad del alumno. Si la edad es menor que 0 o mayor que 100, lanza una excepcion
     */
    public void setEdad(int edad) {
        if (edad > 0 && edad < 100) {
            this.edad = edad;
        } else {
            throw new IllegalArgumentException("La edad debe ser mayor que 0 y menor que 100");
        }
    }

    /**
     * Obtiene la nota del alumno
     *
     * @return Nota del alumno
     */
    public float getNota() {
        return nota;
    }

    /**
     * Asigna la nota de un alumno
     *
     * @param nota Nota del alumno. Entre 0 y 10. Si la nota es menor que 0 o mayor que 10, lanza una excepcion
     */
    public void setNota(float nota) {
        if (nota >= 0.0f && nota <= 10.0f) {
            this.nota = (float) Math.round(nota * 100) / 100;
            calificacion = calcularCalificacion();
        } else {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 10");
        }
    }

    /**
     * Obtiene la calificacion del alumno
     *
     * @return Calificacion del alumno
     */
    public String getCalificacion() {
        return calificacion;
    }

    /**
     * Calcula la calificacion del alumno
     *
     * @return Calificacion del alumno
     */
    private String calcularCalificacion() {
        if (nota < 5.0f) {
            return "Suspenso";
        } else if (nota <= 5.99f) {
            return "Aprobado";
        } else if (nota <= 6.99f) {
            return "Bien";
        } else if (nota <= 8.99f) {
            return "Notable";
        } else {
            return "Sobresaliente";
        }
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", nota=" + nota +
                ", calificacion='" + calificacion + '\'' +
                '}';
    }
}
