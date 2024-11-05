package UD1.redirecciones.ejercicio1;

import java.io.*;

public class EjecutarVerificarPalindromoDesdeFichero {
    public static void main(String[] args) {
        try {
            // Archivo de entrada
            File inputFile = new File("entrada.txt");

            // Configuramos ProcessBuilder para ejecutar el programa VerificarPalindromo
            ProcessBuilder pb = new ProcessBuilder("java", "VerificarPalindromo");
            pb.redirectInput(ProcessBuilder.Redirect.from(inputFile));  // Redirigimos la entrada desde el archivo

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
