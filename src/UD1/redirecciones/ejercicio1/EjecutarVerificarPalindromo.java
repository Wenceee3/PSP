package UD1.redirecciones.ejercicio1;

import java.io.*;
import java.util.Scanner;

public class EjecutarVerificarPalindromo {
    public static void main(String[] args) {
        try {
            // Leer cadena desde el teclado
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce una cadena: ");
            String cadena = scanner.nextLine();

            // Configuramos ProcessBuilder para ejecutar el programa VerificarPalindromo
            ProcessBuilder pb = new ProcessBuilder("java", "VerificarPalindromo");
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
