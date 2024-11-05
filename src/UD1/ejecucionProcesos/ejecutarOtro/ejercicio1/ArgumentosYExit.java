package UD1.ejecucionProcesos.ejecutarOtro.ejercicio1;

public class ArgumentosYExit {
    public static void main(String[] args) {
        // Si no se introduce ningún argumento
        if (args.length == 0) {
            System.out.println("No se introdujo ningún argumento.");
            System.exit(1);
        }

        String argumento = args[0];

        // Comprobar si es una cadena (lo tratamos como cualquier cadena no numérica)
        try {
            int numero = Integer.parseInt(argumento);

            // Si es un número entero menor que 0
            if (numero < 0) {
                System.out.println("El número es menor que 0.");
                System.exit(3);
            } else {
                // Si es un número entero positivo o 0
                System.out.println("El argumento es un número entero mayor o igual a 0.");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            // Si el argumento es una cadena (no se puede convertir a número)
            System.out.println("El argumento es una cadena.");
            System.exit(2);
        }
    }
}

