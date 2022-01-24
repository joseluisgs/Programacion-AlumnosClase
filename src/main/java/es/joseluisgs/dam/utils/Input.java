package es.joseluisgs.dam.utils;

import java.util.Scanner;

/**
 * Clase que permite leer una entrada por teclado.
 */
public class Input {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Lee una linea entrada por teclado. Devuelve el String
     *
     * @return La entrada.
     */
    public static String readLine() {
        String line = "";
        do {
            line = sc.nextLine();
        } while (line.length() == 0);
        return line;
    }

    /**
     * Lee un entero entrada por teclado.
     *
     * @return El entero.
     */
    public static int readInt() {
        int i = 0;
        boolean ok = false;
        do {
            try {
                i = sc.nextInt();
                ok = true;
            } catch (Exception e) {
                System.err.println("Error: no es un entero.");
                sc.next();
            }
        } while (!ok);
        return i;
    }

    /**
     * Lee un float entrada por teclado.
     *
     * @return El float.
     */
    public static float readFloat() {
        float f = 0;
        boolean ok = false;
        do {
            try {
                f = sc.nextFloat();
                ok = true;
            } catch (Exception e) {
                System.err.println("Error: no es un float.");
                sc.next();
            }
        } while (!ok);
        return f;
    }

    /**
     * Lee un double entrada por teclado.
     *
     * @return El double.
     */
    public static double readDouble() {
        double d = 0;
        boolean ok = false;
        do {
            try {
                d = sc.nextDouble();
                ok = true;
            } catch (Exception e) {
                System.err.println("Error: no es un double.");
                sc.next();
            }
        } while (!ok);
        return d;
    }

    /**
     * Lee un boolean por teclado
     */
    public static boolean readBoolean() {
        boolean b = false;
        boolean ok = false;
        do {
            try {
                b = sc.nextBoolean();
                ok = true;
            } catch (Exception e) {
                System.err.println("Error: no es un boolean.");
                sc.next();
            }
        } while (!ok);
        return b;
    }
}
