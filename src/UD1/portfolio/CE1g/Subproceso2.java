package UD1.portfolio.CE1g;

public class Subproceso2 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Ejecutando Subproceso 2, iteración " + i);
            try {
                Thread.sleep(1500);  // Pausa de 1.5 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
