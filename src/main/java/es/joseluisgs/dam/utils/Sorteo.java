package es.joseluisgs.dam.utils;

public class Sorteo {
    public boolean sortear(int probabilidad) {
        return Math.random() < probabilidad;
    }
}
