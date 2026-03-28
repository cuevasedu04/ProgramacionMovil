package tarea06;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Fred20 extends JFrame {

    JButton[] casillas = new JButton[4];
    int[] secuencia = new int[6];
    Random r = new Random();

    Color[] coloresBrillantes = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

    public Fred20() {
        setTitle("Fred20");
        setSize(350, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 5, 5));

        for (int i = 0; i < casillas.length; i++) {
            casillas[i] = new JButton();
            casillas[i].setBackground(Color.GRAY);
            casillas[i].setFocusPainted(false);

            final int indiceBoton = i;

            casillas[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    casillas[indiceBoton].setBackground(coloresBrillantes[indiceBoton]);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    casillas[indiceBoton].setBackground(Color.GRAY);
                }
            });

            add(casillas[i]);
        }

        crearSecuencia();
        mostrarSecuencia();
    }

    public void crearSecuencia() {
        for (int i = 0; i < secuencia.length; i++) {
            secuencia[i] = r.nextInt(4);
        }

        System.out.print("Secuencia generada: ");
        for (int x : secuencia) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public void mostrarSecuencia() {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

                    for (int i = 0; i < secuencia.length; i++) {
                        int indice = secuencia[i];

                        casillas[indice].setBackground(coloresBrillantes[indice]);
                        Thread.sleep(800);

                        casillas[indice].setBackground(Color.GRAY);
                        Thread.sleep(300);
                    }
                } catch (InterruptedException e) {
                    System.out.println(" hilo interrumpido");
                }
            }
        });
        hilo.start();
    }

    public static void main(String[] args) {
        Fred20 f = new Fred20();
        f.setVisible(true);
    }
}