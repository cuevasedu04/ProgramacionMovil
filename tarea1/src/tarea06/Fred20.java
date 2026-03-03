package tarea06;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Fred20 extends JFrame implements ActionListener {

    JButton[] casillas = new JButton[4];
    int[] secuencia = new int[50];
    int nivelActual = 1;
    int clicUsuario = 0;
    boolean turnoUsuario = false;

    Random r = new Random();
    Color[] coloresBrillantes = {Color.GREEN, Color.RED, Color.YELLOW, Color.BLUE};

    public Fred20() {
        setSize(350, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 5, 5));

        for (int i = 0; i < casillas.length; i++) {
            casillas[i] = new JButton();
            casillas[i].setBackground(Color.DARK_GRAY);
            casillas[i].setFocusPainted(false);
            casillas[i].addActionListener(this);
            add(casillas[i]);
        }

        iniciarJuego();
    }

    public void iniciarJuego() {
        nivelActual = 1;
        secuencia[0] = r.nextInt(4);
        mostrarSecuencia();
    }

    public void mostrarSecuencia() {
        turnoUsuario = false;
        setTitle("Memoria - Nivel " + nivelActual + " (Observa...)");

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

                    for (int i = 0; i < nivelActual; i++) {
                        int indice = secuencia[i];

                        casillas[indice].setBackground(coloresBrillantes[indice]);
                        Thread.sleep(600);

                        casillas[indice].setBackground(Color.DARK_GRAY);
                        Thread.sleep(250);
                    }

                    turnoUsuario = true;
                    clicUsuario = 0;
                    setTitle("Memoria - Nivel " + nivelActual + " (¡Tu turno!)");

                } catch (InterruptedException e) {
                    System.out.println("El hilo fue interrumpido");
                }
            }
        });
        hilo.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!turnoUsuario) {
            return;
        }

        int botonPresionado = -1;
        for (int i = 0; i < 4; i++) {
            if (e.getSource() == casillas[i]) {
                botonPresionado = i;
                break;
            }
        }

        if (botonPresionado == secuencia[clicUsuario]) {
            clicUsuario++;

            if (clicUsuario == nivelActual) {
                nivelActual++;
                secuencia[nivelActual - 1] = r.nextInt(4);
                mostrarSecuencia();
            }
        } else {
            turnoUsuario = false;
            JOptionPane.showMessageDialog(this, "¡Oh no! Te equivocaste.\nLlegaste al nivel " + nivelActual);
            iniciarJuego();
        }
    }

    public static void main(String[] args) {
        Fred20 f = new Fred20();
        f.setVisible(true);
    }
}