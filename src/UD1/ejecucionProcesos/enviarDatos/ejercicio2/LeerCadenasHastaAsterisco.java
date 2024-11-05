package UD1.ejecucionProcesos.enviarDatos.ejercicio2;

import java.util.Scanner;

public class LeerCadenasHastaAsterisco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Introduce una cadena (* para finalizar): ");
            input = scanner.nextLine();
            if (input.equals("*")) {
                System.out.println("Finalizando...");
                break;
            }
            System.out.println("Cadena introducida: " + input);
        }
        System.exit(0);  // Finalización correcta
    }
}

