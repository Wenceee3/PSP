package UD1.ejecucionProcesos.ejecutarOtro.ejercicio1;

import java.io.*;

public class EjecutarArgumentosYExit {
    public static void main(String[] args) {
        try {
            // Configuramos ProcessBuilder para ejecutar el programa ArgumentosYExit
            ProcessBuilder pb;
            if (args.length == 1) {
                pb = new ProcessBuilder("java", "ArgumentosYExit", args[0]);  // Pasamos el argumento
            } else {
                pb = new ProcessBuilder("java", "ArgumentosYExit");  // Sin argumentos
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

            // Actuar según el valor devuelto
            switch (exitVal) {
                case 1:
                    System.out.println("Error: No se proporcionó ningún argumento.");
                    break;
                case 2:
                    System.out.println("Se introdujo una cadena.");
                    break;
                case 3:
                    System.out.println("Se introdujo un número menor que 0.");
                    break;
                case 0:
                    System.out.println("El argumento es un número entero mayor o igual a 0.");
                    break;
                default:
                    System.out.println("Valor de salida no reconocido.");
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

