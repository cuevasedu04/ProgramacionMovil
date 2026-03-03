package tarea06;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ContadorGrafico extends JFrame {

    JLabel etContador;
    Font f = new Font("Courier", Font.BOLD, 80);

    public ContadorGrafico() {
        setTitle("Contador Automático");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.BLACK);

        etContador = new JLabel("0", SwingConstants.CENTER);
        etContador.setFont(f);
        etContador.setForeground(Color.GREEN);

        add(etContador);

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    etContador.setText(String.valueOf(i));
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        System.out.println("Error en la pausa del contador");
                    }
                }
            }
        });

        hilo.start();
    }

    public static void main(String[] args) {
        ContadorGrafico cg = new ContadorGrafico();
        cg.setVisible(true);
    }
}