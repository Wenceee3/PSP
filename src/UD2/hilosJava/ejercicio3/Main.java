package UD2.hilosJava.ejercicio3;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String mensaje = "Mensaje " + (i + 1);
            HolaMundoRunnable runnable = new HolaMundoRunnable(mensaje);
            Thread hilo = new Thread(runnable);
            hilo.start();
        }
    }
}
