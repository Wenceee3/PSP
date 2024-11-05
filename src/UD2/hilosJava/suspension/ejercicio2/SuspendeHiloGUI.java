package UD2.hilosJava.suspension.ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HiloContador implements Runnable {
    private boolean pausar = false; // Bandera para controlar la pausa
    private int contador = 0; // Contador del hilo
    private JLabel estadoLabel; // Label para mostrar el estado

    public HiloContador(JLabel estadoLabel) {
        this.estadoLabel = estadoLabel;
    }

    public synchronized void pausar() {
        pausar = true;
        actualizarEstado("Suspendido");
    }

    public synchronized void continuar() {
        pausar = false;
        notify();
        actualizarEstado("Corriendo");
    }

    public int getContador() {
        return contador;
    }

    private void actualizarEstado(String estado) {
        estadoLabel.setText(estado);
    }

    @Override
    public void run() {
        try {
            while (contador < 10) {
                synchronized (this) {
                    while (pausar) {
                        wait();
                    }
                }
                System.out.println("Contador: " + contador);
                contador++;
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido");
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
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public SuspendeHiloGUI() {
        setTitle("Control de Hilos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 3));

        JLabel estadoHilo1 = new JLabel("Estado Hilo 1");
        JLabel estadoHilo2 = new JLabel("Estado Hilo 2");
        hilo1 = new HiloContador(estadoHilo1);
        hilo2 = new HiloContador(estadoHilo2);

        btnComenzar = new JButton("Comenzar Proceso");
        btnFinalizar = new JButton("Finalizar Proceso");
        btnFinalizar.setEnabled(false);

        JButton btnPausarHilo1 = new JButton("Pausar Hilo 1");
        JButton btnReanudarHilo1 = new JButton("Reanudar Hilo 1");
        JButton btnPausarHilo2 = new JButton("Pausar Hilo 2");
        JButton btnReanudarHilo2 = new JButton("Reanudar Hilo 2");

        btnComenzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarHilos();
            }
        });

        btnFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarHilos();
            }
        });

        btnPausarHilo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hilo1.pausar();
            }
        });

        btnReanudarHilo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hilo1.continuar();
            }
        });

        btnPausarHilo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hilo2.pausar();
            }
        });

        btnReanudarHilo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hilo2.continuar();
            }
        });

        add(estadoHilo1);
        add(btnPausarHilo1);
        add(btnReanudarHilo1);
        add(estadoHilo2);
        add(btnPausarHilo2);
        add(btnReanudarHilo2);
        add(btnComenzar);
        add(btnFinalizar);

        setVisible(true);
    }

    private void iniciarHilos() {
        if (thread1 == null && thread2 == null) {
            thread1 = new Thread(hilo1);
            thread2 = new Thread(hilo2);
            thread1.start();
            thread2.start();
            btnComenzar.setEnabled(false);
            btnFinalizar.setEnabled(true);
        }
    }

    private void finalizarHilos() {
        hilo1.continuar();
        hilo2.continuar();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Hilos interrumpidos");
        }
        System.out.println("Contador Hilo 1 finalizado: " + hilo1.getContador());
        System.out.println("Contador Hilo 2 finalizado: " + hilo2.getContador());
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SuspendeHiloGUI::new);
    }
}
