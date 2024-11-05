package UD2.hilosJava.sincronizacion.ejercicio1;

public class SacarDinero extends Thread {
    private String nombre;
    private Cuenta cuenta;

    public SacarDinero(String nombre, Cuenta cuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            cuenta.retirarDinero(nombre, 10);
        }
    }
}
