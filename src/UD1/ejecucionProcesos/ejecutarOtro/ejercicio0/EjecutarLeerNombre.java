package UD1.ejecucionProcesos.ejecutarOtro.ejercicio0;

import java.io.*;

public class EjecutarLeerNombre {
    public static void main(String[] args) {
        try {
            // Ejecutamos el programa LeerNombre.java con o sin argumentos
            ProcessBuilder pb;
            if (args.length == 1) {
                pb = new ProcessBuilder("java", "LeerNombre", args[0]);  // Pasamos el argumento al programa
            } else {
                pb = new ProcessBuilder("java", "LeerNombre");  // Sin argumentos
            }

            // Iniciamos el proceso
            Process process = pb.start();

            // Mostramos la salida del proceso
            InputStream is = process.getInputStream();
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }
            is.close();

            // Esperamos que el proceso termine y capturamos su valor de salida
            int exitVal = process.waitFor();
            System.out.println("Valor de salida del proceso: " + exitVal);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
