package UD1.ejecucionProcesos.ejecutarOtro.ejercicio2;

public class MostrarCadena5Veces {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error: No se proporcionó ninguna cadena.");
            System.exit(1);
        }

        String cadena = args[0];
        for (int i = 0; i < 5; i++) {
            System.out.println(cadena);
        }
        System.exit(0);
    }
}

