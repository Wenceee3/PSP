package UD2.hilosJava.ejercicio1.HiloRunnable;

class HiloTic implements Runnable {
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

class HiloTac implements Runnable {
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

public class UsaHilo {
    public static void main(String[] args) {
        HiloTic hiloTic = new HiloTic();
        HiloTac hiloTac = new HiloTac();

        Thread threadTic = new Thread(hiloTic);
        Thread threadTac = new Thread(hiloTac);

        threadTic.start();
        threadTac.start();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

