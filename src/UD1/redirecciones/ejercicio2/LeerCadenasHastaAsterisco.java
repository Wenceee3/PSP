package UD1.redirecciones.ejercicio2;

import java.util.Scanner;

public class LeerCadenasHastaAsterisco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            input = scanner.nextLine();
            if (input.equals("*")) {
                break;
            }
            System.out.println(input);
        }
    }
}

