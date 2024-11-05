package UD2.hilosJava.suspension.ejercicio1;

import java.util.Scanner;

class HiloContador implements Runnable {
    private boolean pausar = false; // Bandera para controlar que se pause el hilo

    // Poner bandera a true para que la hebra se pause cuando la compruebe
    public synchronized void pausar() {
        pausar = true;
    }

    // Poner bandera a false y despertar a la hebra
    public synchronized void continuar() {
        pausar = false;
        notify();
    }

    /*
     Cuenta hasta 10 esperando medio segundo entre cada número
     y va comprobando si debe pausarse
     */
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                // Si la bandera marca pausar, el hilo se suspende
                synchronized (this) {
                    while (pausar) {
                        wait();
                    }
                }

                System.out.println("Vuelta número: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido");
        }
    }
}

public class SuspendeHilo {
    public static void main(String[] args) {
        // Crea hilo
        HiloContador hiloContador = new HiloContador();
        Thread hebra = new Thread(hiloContador);

        // Comienza hilo
        hebra.start();

        Scanner scanner = new Scanner(System.in);

        label:
        while (true) {
            System.out.println("Introduce 'S' para pausar, 'R' para reanudar, o '*' para salir:");
            String input = scanner.nextLine();

            switch (input) {
                case "*":
                    break label; // Salir del bucle y terminar el programa
                case "S":
                    System.out.println("Pausando hilo...");
                    hiloContador.pausar();
                    break;
                case "R":
                    System.out.println("Reanudando hilo...");
                    hiloContador.continuar();
                    break;
                default:
                    System.out.println("Entrada no válida, prueba de nuevo.");
                    break;
            }
        }

        // Terminar el hilo de forma limpia
        try {
            hiloContador.continuar(); // Asegurarse de que el hilo pueda continuar si está pausado
            hebra.join(); // Espera a que el hilo termine
        } catch (InterruptedException e) {
            System.out.println("Main interrumpido");
        }

        System.out.println("Hilo finalizado");
        scanner.close();
    }
}
