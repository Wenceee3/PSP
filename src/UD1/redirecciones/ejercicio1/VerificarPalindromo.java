package UD1.redirecciones.ejercicio1;

import java.util.Scanner;

public class VerificarPalindromo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una cadena: ");
        String cadena = scanner.nextLine().trim();

        if (cadena.isEmpty()) {
            System.out.println("La cadena está vacía.");
        } else {
            String invertida = new StringBuilder(cadena).reverse().toString();
            if (cadena.equalsIgnoreCase(invertida)) {
                System.out.println("La cadena es un palíndromo.");
            } else {
                System.out.println("La cadena no es un palíndromo.");
            }
        }
    }
}
