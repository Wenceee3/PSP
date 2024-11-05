package UD2.hilosJava.ejercicio2.HiloRunnable;

class HolaMundoRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hola mundo desde el hilo " + Thread.currentThread().getName());
    }
}

public class UsaRunnableHolaMundo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            HolaMundoRunnable holaMundoRunnable = new HolaMundoRunnable();
            Thread hilo = new Thread(holaMundoRunnable);
            hilo.start();
        }
    }
}
