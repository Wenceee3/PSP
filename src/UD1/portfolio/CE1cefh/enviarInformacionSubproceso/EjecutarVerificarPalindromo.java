package UD1.portfolio.CE1cefh.enviarInformacionSubproceso;

import java.io.*;

public class  EjecutarVerificarPalindromo {
    public static void main(String[] args) {
        try {
            // Enviar una cadena al subproceso
            ProcessBuilder pb = new ProcessBuilder("java", "VerificarPalindromo");
            Process process = pb.start();

            // Proporcionar entrada al subproceso
            OutputStream os = process.getOutputStream();
            PrintWriter writer = new PrintWriter(os);
            writer.println("anilina");  // La cadena que queremos verificar
            writer.flush();
            writer.close();  // Cerramos el flujo de escritura

            // Capturar la salida del subproceso
            InputStream is = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Salida del subproceso: " + line);
            }
            is.close();

            // Obtener el valor de salida
            int exitVal = process.waitFor();
            System.out.println("Valor de salida del subproceso: " + exitVal);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

