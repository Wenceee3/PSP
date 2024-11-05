package UD2.hilosJava.ejercicio2.HiloThread;

class HiloHolaMundo extends Thread {
    @Override
    public void run() {
        System.out.println("Hola mundo desde el hilo " + this.getName());
    }
}

public class UsaHiloHolaMundo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            HiloHolaMundo hilo = new HiloHolaMundo();
            hilo.start();
        }
    }
}

