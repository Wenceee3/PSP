package UD1.portfolio.CE1cefh.valorSalidaSubproceso;

import java.io.*;

public class ValorSalidaSubproceso {
    public static void main(String[] args) {
        try {
            // Crear un subproceso
            ProcessBuilder pb = new ProcessBuilder("java", "VerificarPalindromo");
            Process process = pb.start();

            // Esperar a que el subproceso termine
            int exitVal = process.waitFor();

            // Imprimir el valor de salida
            if (exitVal == 0) {
                System.out.println("El subproceso finalizó correctamente con valor de salida: " + exitVal);
            } else {
                System.out.println("El subproceso terminó con errores. Valor de salida: " + exitVal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

