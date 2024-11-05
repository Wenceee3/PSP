package UD1.ejecucionProcesos.enviarDatos.ejercicio1;

import java.io.*;
import java.util.Scanner;

public class EjecutarSumarDosNumeros {
    public static void main(String[] args) {
        try {
            // Leer los números desde el teclado
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el primer número: ");
            String num1 = scanner.nextLine();
            System.out.print("Introduce el segundo número: ");
            String num2 = scanner.nextLine();

            // Configuramos ProcessBuilder para ejecutar el programa SumarDosNumeros
            ProcessBuilder pb = new ProcessBuilder("java", "SumarDosNumeros");
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
