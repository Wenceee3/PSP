package UD1.ejecucionProcesos.ejecutarOtro.ejercicio0;

public class LeerNombre {
    public static void main(String[] args) {
        // Comprobamos si se ha pasado un argumento (nombre)
        if (args.length != 1) {
            System.out.println("Error: No se ha proporcionado un nombre.");
            System.exit(-1);  // Finalización incorrecta
        } else {
            // Si se proporciona el argumento, lo mostramos
            System.out.println("Hola, " + args[0] + "!");
            System.exit(0);  // Finalización correcta
        }
    }
}

