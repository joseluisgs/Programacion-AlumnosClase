package es.joseluisgs.dam.models;

import es.joseluisgs.dam.creators.AlumnoCreator;

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

    public Alumno read(int posicion) throws RuntimeException {
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

    public Alumno readOrNull(int posicion) {
        if (posicion < MAX_ALUMNOS && posicion >= 0) {
            if (alumnos[posicion] != null) {
                return alumnos[posicion];
            } else {
                System.err.println("No hay alumno en la posición " + posicion);
                return null;
            }
        } else {
            System.err.println("No se puede leer el alumno en la posición " + posicion + " porque excede el tamaño de la clase");
            return null;
        }
    }

    public void update(Alumno alumno, int posicion) {
        if (posicion < MAX_ALUMNOS && posicion >= 0) {
            if (alumnos[posicion] != null) {
                alumnos[posicion] = alumno;
            } else {
                System.err.println("No hay alumno en la posición " + posicion);
            }
        } else {
            System.err.println("No se puede actualizar el alumno en la posición " + posicion + " porque excede el tamaño de la clase");
        }
    }

    public void delete(int posicion) {
        if (posicion < MAX_ALUMNOS && posicion >= 0) {
            if (alumnos[posicion] != null) {
                alumnos[posicion] = null;
            } else {
                System.err.println("No hay alumno en la posición " + posicion);
            }
        } else {
            System.err.println("No se puede actualizar el alumno en la posición " + posicion + " porque excede el tamaño de la clase");
        }
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }

    public void initRandom() {
        numAlumnos = 0;
        AlumnoCreator creator = new AlumnoCreator();
        for (int i = 0; i < MAX_ALUMNOS; i++) {
            alumnos[i] = creator.createRandom();
            numAlumnos++;
        }
    }

    public int getNumeroAprobados() {
        int aprobados = 0;
        for (int i = 0; i < MAX_ALUMNOS; i++) {
            if (alumnos[i] != null && alumnos[i].getNota() >= 5) {
                aprobados++;
            }
        }
        return aprobados;
    }

    public int getNumeroSuspensos() {
        int suspensos = 0;
        for (int i = 0; i < MAX_ALUMNOS; i++) {
            if (alumnos[i] != null && alumnos[i].getNota() < 5) {
                suspensos++;
            }
        }
        return suspensos;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "curso='" + curso + '\'' +
                ", grupo=" + grupo +
                '}';
    }


    public String getListaAprobados() {
        String result = "";
        if (numAlumnos != 0) {
            for (int i = 0; i < MAX_ALUMNOS; i++) {
                if (alumnos[i] != null && alumnos[i].getNota() >= 5) {
                    result += (i + 1) + "- " + alumnos[i].toString() + "\n";
                }
            }
        } else {
            result = "No hay alumnos en la clase";
        }

        return result;
    }

    public String getListaSuspensos() {
        String result = "";
        if (numAlumnos != 0) {
            for (int i = 0; i < MAX_ALUMNOS; i++) {
                if (alumnos[i] != null && alumnos[i].getNota() < 5) {
                    result += (i + 1) + "- " + alumnos[i].toString() + "\n";
                }
            }
        } else {
            result = "No hay alumnos en la clase";
        }

        return result;
    }

    public float percentAprobados() {
        float per = (float) getNumeroAprobados() / (float) numAlumnos * 100.0f;
        return Math.round(per * 100.0f) / 100.0f;
    }

    public float percentSuspensos() {
        float per = (float) getNumeroSuspensos() / (float) numAlumnos * 100.0f;
        return Math.round(per * 100.0f) / 100.0f;
    }

    public float getNotaMedia() {
        float suma = 0.0f;
        for (int i = 0; i < MAX_ALUMNOS; i++) {
            if (alumnos[i] != null) {
                suma += alumnos[i].getNota();
            }
        }
        float media = suma / numAlumnos;
        return Math.round(media * 100.0f) / 100.0f;
    }
}
