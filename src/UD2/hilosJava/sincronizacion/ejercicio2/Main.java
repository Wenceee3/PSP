package UD2.hilosJava.sincronizacion.ejercicio2;

public class Main {
    public static void main(String[] args) {
        int totalJugadores = 3; // Definir el número de jugadores
        Arbitro arbitro = new Arbitro(totalJugadores);

        // Crear y lanzar los hilos de los jugadores
        for (int i = 1; i <= totalJugadores; i++) {
            Jugador jugador = new Jugador(i, arbitro);
            jugador.start();
        }
    }
}

