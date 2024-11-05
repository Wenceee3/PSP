package UD2.hilosJava.sincronizacion.ejercicio2;

public class Jugador extends Thread {
    private int idJugador;
    private Arbitro arbitro;

    public Jugador(int idJugador, Arbitro arbitro) {
        this.idJugador = idJugador;
        this.arbitro = arbitro;
    }

    @Override
    public void run() {
        while (!arbitro.juegoTerminado()) {
            // Espera su turno
            while (arbitro.obtenerTurno() != idJugador) {
                try {
                    Thread.sleep(10); // Espera un poco para no consumir mucha CPU
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Si es su turno, genera un número aleatorio entre 1 y 10
            int numeroJugado = (int) (Math.random() * 10) + 1;

            // Llama al método del árbitro para comprobar la jugada
            arbitro.comprobarJugada(idJugador, numeroJugado);
        }
    }
}

