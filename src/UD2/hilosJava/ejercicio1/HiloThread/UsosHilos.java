package UD2.hilosJava.ejercicio1.HiloThread;

public class UsosHilos {
    public static void main(String[] args) {
        HiloTic htic = new HiloTic();
        HiloTac htac = new HiloTac();
        htic.start();
        htac.start();
    }
}
