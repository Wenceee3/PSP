package UD1.ejecucionProcesos.enviarDatos.ejercicio1;

import java.util.Scanner;

public class SumarDosNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Leer el primer número
            System.out.print("Introduce el primer número: ");
            double numero1 = Double.parseDouble(scanner.nextLine());

            // Leer el segundo número
            System.out.print("Introduce el segundo número: ");
            double numero2 = Double.parseDouble(scanner.nextLine());

            // Mostrar la suma
            double suma = numero1 + numero2;
            System.out.println("La suma de los dos números es: " + suma);
            System.exit(0);  // Finalización correcta

        } catch (NumberFormatException e) {
            System.out.println("Error: Debes introducir números válidos.");
            System.exit(1);  // Finalización incorrecta
        }
    }
}

