package UD2.hilosJava.sincronizacion.ejercicio1;

public class Cuenta {
    private double saldo;

    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double obtenerSaldo() {
        return saldo;
    }

    public synchronized void retirarDinero(String nombre, double cantidad) {
        if (saldo < 0) {
            System.out.println("El saldo es negativo. Persona: " + nombre + ". Saldo: " + saldo);
            return;
        }

        if (saldo >= cantidad) {
            System.out.println(nombre + " intenta retirar " + cantidad + ". Saldo actual: " + saldo);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            saldo -= cantidad;
            System.out.println(nombre + " ha retirado " + cantidad + ". Saldo restante: " + saldo);
        } else {
            System.out.println("No hay saldo suficiente para " + nombre + ". Saldo actual: " + saldo);
        }
    }
}


