package es.joseluisgs.dam.models;

public class Clase {
    private final int MAX_ALUMNOS = 30;
    private int numAlumnos = 0;

    private String curso;
    private int grupo;
    private Alumno[] alumnos;


    public Clase(String curso, int grupo) {
        this.curso = curso;
        this.grupo = grupo;
        alumnos = new Alumno[MAX_ALUMNOS];
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public void createAlumno(Alumno alumno, int posicion) {
        if (posicion < MAX_ALUMNOS && posicion >= 0) {
            alumnos[posicion] = alumno;
            numAlumnos++;
        } else {
            System.err.println("No se puede añadir el alumno en la posición " + posicion + " porque excede el tamaño de la clase");
        }

    }

    public void createAlumno(Alumno alumno) {
        for (int i = 0; i < MAX_ALUMNOS; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = alumno;
                numAlumnos++;
                return;
            }
        }
        System.err.println("No se puede añadir el alumno porque excede el tamaño de la clase");
    }

    public String readAll() {
        String result = "";
        if (numAlumnos != 0) {
            for (int i = 0; i < alumnos.length; i++) {
                if (alumnos[i] != null) {
                    result += (i + 1) + "- " + alumnos[i].toString() + "\n";
                }
            }
        } else {
            result = "No hay alumnos en la clase";
        }
        return result;
    }

    public Alumno read(int posicion) {
        if (posicion < MAX_ALUMNOS && posicion >= 0) {
            if (alumnos[posicion] != null) {
                return alumnos[posicion];
            } else {
                throw new RuntimeException("No hay alumno en la posición " + posicion);
            }
        } else {
            throw new RuntimeException("No se puede leer el alumno en la posición " + posicion + " porque excede el tamaño de la clase");
        }
    }

    @Override
    public String toString() {
        return "Clase{" +
                "curso='" + curso + '\'' +
                ", grupo=" + grupo +
                '}';
    }


}
