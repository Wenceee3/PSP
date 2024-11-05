package UD2.hilosJava.ejercicio1.HiloThread;

public class HiloTic extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("TIC");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
