package UD2.hilosJava.ejercicio1.HiloThread;

public class HiloTac extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("TAC");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
