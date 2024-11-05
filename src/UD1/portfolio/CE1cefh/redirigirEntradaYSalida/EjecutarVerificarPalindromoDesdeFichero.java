package UD1.portfolio.CE1cefh.redirigirEntradaYSalida;

import java.io.*;

public class EjecutarVerificarPalindromoDesdeFichero {
    public static void main(String[] args) {
        try {
            // Crear archivo de entrada y salida
            File inputFile = new File("entrada.txt");
            File outputFile = new File("salida.txt");

            // Configuramos ProcessBuilder para redirigir entrada y salida
            ProcessBuilder pb = new ProcessBuilder("java", "VerificarPalindromo");
            pb.redirectInput(inputFile);  // Redirige entrada desde el archivo
            pb.redirectOutput(outputFile);  // Redirige salida al archivo

            // Iniciamos el subproceso
            Process process = pb.start();

            // Esperar la finalización del subproceso
            int exitVal = process.waitFor();
            System.out.println("Valor de salida del subproceso: " + exitVal);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
