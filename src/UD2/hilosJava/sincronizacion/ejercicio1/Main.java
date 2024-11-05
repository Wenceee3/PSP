package UD2.hilosJava.sincronizacion.ejercicio1;

public class Main {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(40);

        SacarDinero persona1 = new SacarDinero("Persona 1", cuenta);
        SacarDinero persona2 = new SacarDinero("Persona 2", cuenta);

        persona1.start();
        persona2.start();

        try {
            persona1.join();
            persona2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
