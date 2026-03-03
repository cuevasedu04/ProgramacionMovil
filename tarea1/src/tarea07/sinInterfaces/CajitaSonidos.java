package tarea07.sinInterfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CajitaSonidos extends JFrame {

    JComboBox<String> combo;
    JButton boton;
    JLabel etSonido;

    public CajitaSonidos() {
        setTitle("Cajita de Sonidos");
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 1, 20, 20));
        panelPrincipal.setBorder(new EmptyBorder(30, 30, 30, 30));
        panelPrincipal.setBackground(new Color(245, 245, 250)); // Fondo claro

        Font fuenteBase = new Font("Arial", Font.BOLD, 22);

        combo = new JComboBox<>(new String[]{"Perro", "Gato", "Pato", "Grillo"});
        combo.setFont(fuenteBase);
        ((JLabel) combo.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        boton = new JButton("Emitir sonido");
        boton.setFont(fuenteBase);
        boton.setBackground(new Color(70, 130, 180));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);

        etSonido = new JLabel("...", SwingConstants.CENTER);
        etSonido.setFont(new Font("Courier", Font.BOLD, 36));
        etSonido.setForeground(new Color(220, 20, 60));

        panelPrincipal.add(combo);
        panelPrincipal.add(boton);
        panelPrincipal.add(etSonido);

        add(panelPrincipal);

        boton.addActionListener(e -> {
            Animal a = null;
            String seleccion = (String) combo.getSelectedItem();

            switch (seleccion) {
                case "Perro": a = new Perro(); break;
                case "Gato":  a = new Gato(); break;
                case "Pato":  a = new Pato(); break;
                case "Grillo": a = new Grillo(); break;
            }

            if (a != null) {
                etSonido.setText('"' + a.emitirSonido() + '"');
            }
        });
    }

    public static void main(String[] args) {
        CajitaSonidos cs = new CajitaSonidos();
        cs.setVisible(true);
    }
}