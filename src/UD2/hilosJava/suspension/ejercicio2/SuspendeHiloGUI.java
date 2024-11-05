package UD2.hilosJava.suspension.ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HiloContador implements Runnable {
    private boolean pausar = false; // Bandera para controlar la pausa del hilo
    private int contador = 0; // Contador que incrementa hasta 10
    private JLabel estadoLabel; // Etiqueta que muestra el estado del hilo

    // Constructor de HiloContador, recibe un JLabel para mostrar el estado
    public HiloContador(JLabel estadoLabel) {
        this.estadoLabel = estadoLabel;
    }

    // Método sincronizado para pausar el hilo
    public synchronized void pausar() {
        pausar = true; // Cambia la bandera 'pausar' a true
        actualizarEstado("Suspendido"); // Actualiza el estado visual a "Suspendido"
    }

    // Método sincronizado para reanudar el hilo
    public synchronized void continuar() {
        pausar = false; // Cambia la bandera 'pausar' a false
        notify(); // Notifica a cualquier hilo que está esperando en 'wait()'
        actualizarEstado("Corriendo"); // Actualiza el estado visual a "Corriendo"
    }

    // Método para obtener el valor del contador
    public int getContador() {
        return contador; // Devuelve el valor actual del contador
    }

    // Método para actualizar la etiqueta con el estado del hilo
    private void actualizarEstado(String estado) {
        estadoLabel.setText(estado); // Cambia el texto de la etiqueta con el estado recibido
    }

    // Método run() donde se ejecuta el hilo
    @Override
    public void run() {
        try {
            while (contador < 10) { // El hilo sigue ejecutándose hasta que el contador llegue a 10
                synchronized (this) {
                    while (pausar) {
                        wait(); // Si el hilo está pausado, espera hasta que se le notifique para continuar
                    }
                }
                System.out.println("Contador: " + contador); // Muestra el valor del contador en la consola
                contador++; // Incrementa el contador
                Thread.sleep(500); // Pausa el hilo durante 500ms
            }
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido"); // Si el hilo es interrumpido, muestra un mensaje en la consola
        }
    }
}

public class SuspendeHiloGUI extends JFrame {
    private HiloContador hilo1;
    private HiloContador hilo2;
    private Thread thread1;
    private Thread thread2;
    private JButton btnComenzar;
    private JButton btnFinalizar;

    // Constructor de la interfaz gráfica
    public SuspendeHiloGUI() {
        setTitle("Control de Hilos"); // Título de la ventana
        setSize(400, 300); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Comportamiento al cerrar la ventana
        setLayout(new BorderLayout()); // Usamos BorderLayout para tener un solo contenedor principal

        // Crear los paneles para agrupar los controles de cada hilo
        JPanel panelHilo1 = new JPanel(new GridLayout(3, 1)); // Panel para Hilo 1 (3 botones)
        JPanel panelHilo2 = new JPanel(new GridLayout(3, 1)); // Panel para Hilo 2 (3 botones)

        // Crear etiquetas para mostrar el estado de cada hilo
        JLabel estadoHilo1 = new JLabel("Estado Hilo 1");
        JLabel estadoHilo2 = new JLabel("Estado Hilo 2");

        // Crear los hilos y asociarlos con las etiquetas de estado
        hilo1 = new HiloContador(estadoHilo1);
        hilo2 = new HiloContador(estadoHilo2);

        // Crear los botones de la interfaz gráfica
        btnComenzar = new JButton("Comenzar Proceso");
        btnFinalizar = new JButton("Finalizar Proceso");
        btnFinalizar.setEnabled(false); // Desactiva el botón de finalizar al inicio

        // Botones para pausar y reanudar los hilos
        JButton btnPausarHilo1 = new JButton("Pausar Hilo 1");
        JButton btnReanudarHilo1 = new JButton("Reanudar Hilo 1");
        JButton btnPausarHilo2 = new JButton("Pausar Hilo 2");
        JButton btnReanudarHilo2 = new JButton("Reanudar Hilo 2");

        // Añadir los botones correspondientes al panel de Hilo 1
        panelHilo1.add(estadoHilo1);
        panelHilo1.add(btnPausarHilo1);
        panelHilo1.add(btnReanudarHilo1);

        // Añadir los botones correspondientes al panel de Hilo 2
        panelHilo2.add(estadoHilo2);
        panelHilo2.add(btnPausarHilo2);
        panelHilo2.add(btnReanudarHilo2);

        // Añadir listeners para controlar los botones
        btnComenzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarHilos(); // Inicia los hilos cuando se presiona el botón "Comenzar Proceso"
            }
        });

        btnFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarHilos(); // Finaliza los hilos cuando se presiona el botón "Finalizar Proceso"
            }
        });

        btnPausarHilo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hilo1.pausar(); // Pausa el Hilo 1 cuando se presiona el botón "Pausar Hilo 1"
            }
        });

        btnReanudarHilo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hilo1.continuar(); // Reanuda el Hilo 1 cuando se presiona el botón "Reanudar Hilo 1"
            }
        });

        btnPausarHilo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hilo2.pausar(); // Pausa el Hilo 2 cuando se presiona el botón "Pausar Hilo 2"
            }
        });

        btnReanudarHilo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hilo2.continuar(); // Reanuda el Hilo 2 cuando se presiona el botón "Reanudar Hilo 2"
            }
        });

        // Crear un panel inferior para los botones "Comenzar" y "Finalizar"
        JPanel panelInferior = new JPanel(new GridLayout(1, 2)); // Dos botones en una fila
        panelInferior.add(btnComenzar);
        panelInferior.add(btnFinalizar);

        // Añadir los paneles y los botones a la ventana
        add(panelHilo1, BorderLayout.WEST); // Panel izquierdo para Hilo 1
        add(panelHilo2, BorderLayout.EAST); // Panel derecho para Hilo 2
        add(panelInferior, BorderLayout.SOUTH); // Panel inferior para los botones "Comenzar" y "Finalizar"

        setVisible(true); // Hace visible la ventana
    }

    // Método para iniciar los hilos
    private void iniciarHilos() {
        if (thread1 == null && thread2 == null) { // Verifica que los hilos no hayan sido creados ya
            thread1 = new Thread(hilo1); // Crea el hilo para hilo1
            thread2 = new Thread(hilo2); // Crea el hilo para hilo2
            thread1.start(); // Inicia el hilo1
            thread2.start(); // Inicia el hilo2
            btnComenzar.setEnabled(false); // Desactiva el botón "Comenzar Proceso" para evitar múltiples inicios
            btnFinalizar.setEnabled(true); // Activa el botón "Finalizar Proceso"
        }
    }

    // Método para finalizar los hilos
    private void finalizarHilos() {
        hilo1.continuar(); // Asegura que el Hilo 1 continúe si estaba pausado
        hilo2.continuar(); // Asegura que el Hilo 2 continúe si estaba pausado
        try {
            thread1.join(); // Espera a que el Hilo 1 termine su ejecución
            thread2.join(); // Espera a que el Hilo 2 termine su ejecución
        } catch (InterruptedException e) {
            System.out.println("Hilos interrumpidos"); // En caso de ser interrumpidos, se muestra un mensaje
        }
        // Imprime el valor final de los contadores de ambos hilos
        System.out.println("Contador Hilo 1 finalizado: " + hilo1.getContador());
        System.out.println("Contador Hilo 2 finalizado: " + hilo2.getContador());
        System.exit(0); // Finaliza la aplicación
    }

    // Método main que lanza la interfaz gráfica
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SuspendeHiloGUI::new); // Ejecuta la interfaz gráfica
    }
}
