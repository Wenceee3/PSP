package UD1.portfolio.CE1g;

import java.io.*;

public class EjecutarSubprocesosEnParalelo {
    public static void main(String[] args) {
        try {
            // Crear el primer subproceso
            ProcessBuilder pb1 = new ProcessBuilder("java", "Subproceso1");
            Process proceso1 = pb1.start();

            // Crear el segundo subproceso
            ProcessBuilder pb2 = new ProcessBuilder("java", "Subproceso2");
            Process proceso2 = pb2.start();

            // Crear hilos para gestionar los subprocesos de manera concurrente
            Thread hilo1 = new Thread(() -> {
                try {
                    // Capturar y mostrar la salida del primer subproceso
                    InputStream is1 = proceso1.getInputStream();
                    BufferedReader reader1 = new BufferedReader(new InputStreamReader(is1));
                    String linea1;
                    while ((linea1 = reader1.readLine()) != null) {
                        System.out.println("Subproceso 1: " + linea1);
                    }
                    is1.close();

                    // Esperar la finalización del subproceso 1
                    int exitVal1 = proceso1.waitFor();
                    System.out.println("Subproceso 1 terminó con valor de salida: " + exitVal1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            Thread hilo2 = new Thread(() -> {
                try {
                    // Capturar y mostrar la salida del segundo subproceso
                    InputStream is2 = proceso2.getInputStream();
                    BufferedReader reader2 = new BufferedReader(new InputStreamReader(is2));
                    String linea2;
                    while ((linea2 = reader2.readLine()) != null) {
                        System.out.println("Subproceso 2: " + linea2);
                    }
                    is2.close();

                    // Esperar la finalización del subproceso 2
                    int exitVal2 = proceso2.waitFor();
                    System.out.println("Subproceso 2 terminó con valor de salida: " + exitVal2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // Iniciar ambos hilos en paralelo
            hilo1.start();
            hilo2.start();

            // Esperar a que ambos hilos terminen
            hilo1.join();
            hilo2.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

