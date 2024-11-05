package UD1.portfolio.CE1g;

public class Subproceso1 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Ejecutando Subproceso 1, iteración " + i);
            try {
                Thread.sleep(1000);  // Pausa de 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
