package UD2.hilosJava.ejercicio3;

public class HolaMundoRunnable implements Runnable {
    private String mensaje;

    public HolaMundoRunnable(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        try {
            // Hilo duerme un tiempo proporcional al identificador
            int idHilo = (int) Thread.currentThread().getId();
            Thread.sleep(idHilo * 100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Mostrar mensaje
        System.out.println("Hola mundo " + mensaje + " desde el hilo " + Thread.currentThread().getId());
    }
}

