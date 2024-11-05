package UD1.ejecucionProcesos.enviarDatos.ejercicio2;

public class EjecutarLeerCadenasHastaAsterisco {
    public static void main(String[] args) {
        try {
            // Configuramos ProcessBuilder para ejecutar el programa LeerCadenasHastaAsterisco
            ProcessBuilder pb = new ProcessBuilder("java", "LeerCadenasHastaAsterisco");
            Process process = pb.start();

            // Mientras el proceso esté vivo, esperamos 1 segundo
            while (process.isAlive()) {
                try {
                    Thread.sleep(1000);  // Espera de 1 segundo
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Capturamos el valor de salida del proceso
            int exitVal = process.waitFor();
            System.out.println("Valor de salida del proceso: " + exitVal);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
