package UD2.hilosJava.sincronizacion.ejercicio2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Arbitro {
    private int numeroAdivinar;
    private int turno;
    private int totalJugadores;
    private boolean juegoTerminado;
    private Lock lock;

    public Arbitro(int totalJugadores) {
        this.totalJugadores = totalJugadores;
        this.turno = 1; // El primer jugador inicia
        this.numeroAdivinar = (int) (Math.random() * 10) + 1; // Número aleatorio entre 1 y 10
        this.juegoTerminado = false;
        this.lock = new ReentrantLock(); // Usamos un lock para sincronizar el acceso al turno
    }

    // Método para obtener el turno actual
    public int obtenerTurno() {
        return turno;
    }

    // Método para comprobar la jugada
    public void comprobarJugada(int jugadorId, int numeroJugado) {
        lock.lock();
        try {
            if (juegoTerminado) {
                return; // El juego ya ha terminado
            }

            System.out.println("Jugador " + jugadorId + " dice: " + numeroJugado);

            // Si el jugador adivina el número, termina el juego
            if (numeroJugado == numeroAdivinar) {
                System.out.println("El jugador " + jugadorId + " gana, ¡ha adivinado el número!");
                juegoTerminado = true;
                return;
            }

            // Si no es el número correcto, pasa al siguiente jugador
            turno = (turno % totalJugadores) + 1;
            System.out.println("Le toca al jugador " + turno);
        } finally {
            lock.unlock();
        }
    }

    // Método que verifica si el juego terminó
    public boolean juegoTerminado() {
        return juegoTerminado;
    }
}

