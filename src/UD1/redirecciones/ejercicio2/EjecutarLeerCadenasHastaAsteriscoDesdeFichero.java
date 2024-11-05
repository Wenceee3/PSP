package UD1.redirecciones.ejercicio2;

import java.io.*;

public class EjecutarLeerCadenasHastaAsteriscoDesdeFichero {
    public static void main(String[] args) {
        try {
            // Archivo de entrada
            File inputFile = new File("entrada.txt");

            // Configuramos ProcessBuilder para ejecutar el programa LeerCadenasHastaAsterisco
            ProcessBuilder pb = new ProcessBuilder("java", "LeerCadenasHastaAsterisco");
            pb.redirectInput(ProcessBuilder.Redirect.from(inputFile));  // Redirigimos la entrada desde el archivo

            // Iniciamos el proceso
            Process process = pb.start();

            // Esperamos mientras el proceso esté vivo
            while (process.isAlive()) {
                try {
                    Thread.sleep(1000);  // Espera de 1 segundo
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Capturamos el valor de salida del proceso
            int exitVal = process.waitFor();
            System.out.println("Valor de salida del proceso: " + exitVal);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
