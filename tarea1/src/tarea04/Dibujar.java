package tarea04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dibujar extends JFrame {
    PanelDibujo pd;
    JComboBox<String> comboColores;

    public Dibujar() {
        setTitle("Paint Mágico");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] opcionesColores = {
                "Negro", "Rojo", "Naranja", "Amarillo", "Verde",
                "Cian", "Azul", "Morado", "Rosa", "Arcoíris"
        };
        comboColores = new JComboBox<>(opcionesColores);

        JPanel po = new JPanel();
        po.add(comboColores);
        add(po, BorderLayout.SOUTH);

        pd = new PanelDibujo(comboColores);
        add(pd, BorderLayout.CENTER);
    }

    public static void main(String[] a) {
        Dibujar d = new Dibujar();
        d.setVisible(true);
    }

    class PanelDibujo extends JPanel {
        JComboBox<String> cc;
        Color colorActual = Color.BLACK;
        int lastX, lastY;
        float tonoArcoiris = 0.0f;

        public PanelDibujo(JComboBox<String> cc) {
            this.cc = cc;
            setBackground(Color.WHITE);

            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    cambiarColor();
                    lastX = e.getX();
                    lastY = e.getY();
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    Graphics g = getGraphics();

                    // ARCOÍRIS
                    String colorSeleccionado = (String) cc.getSelectedItem();
                    if (colorSeleccionado.equals("Arcoíris")) {
                        g.setColor(Color.getHSBColor(tonoArcoiris, 1.0f, 1.0f));
                        tonoArcoiris += 0.01f;
                        if (tonoArcoiris > 1.0f) tonoArcoiris = 0.0f; // Reinicia el ciclo
                    } else {
                        g.setColor(colorActual);
                    }

                    int x = e.getX();
                    int y = e.getY();
                    g.drawLine(lastX, lastY, x, y);
                    lastX = x;
                    lastY = y;
                }
            });
        }

        public void cambiarColor() {
            String colorDado = (String) cc.getSelectedItem();
            switch (colorDado) {
                case "Negro": colorActual = Color.BLACK; break;
                case "Rojo": colorActual = Color.RED; break;
                case "Naranja": colorActual = Color.ORANGE; break;
                case "Amarillo": colorActual = Color.YELLOW; break;
                case "Verde": colorActual = Color.GREEN; break;
                case "Cian": colorActual = Color.CYAN; break;
                case "Azul": colorActual = Color.BLUE; break;
                case "Morado": colorActual = new Color(128, 0, 128); break;
                case "Rosa": colorActual = Color.PINK; break;
            }
        }
    }
}