package tarea02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Tablas extends JFrame implements ActionListener {
    JComboBox<Integer> tablaDada;
    JTextArea areaTabla;
    JButton btnAceptar;


    public Tablas() {
        setTitle("Tablas de multiplicar");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        areaTabla = new JTextArea();
        add(areaTabla, BorderLayout.CENTER);

        tablaDada = new JComboBox<>();

        for (int i = 1; i <= 10; i++) {
            tablaDada.addItem(i);
        }

        add(tablaDada, BorderLayout.NORTH);

        tablaDada.addActionListener(this);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
    }

    public static void main(String[] args) {
        Tablas t = new Tablas();
        t.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x = Integer.parseInt(tablaDada.getSelectedItem() + "");
        mostrarTabla(x);
    }

    public void mostrarTabla(int tablaDada) {
        areaTabla.setText("");

        for (int i = 1; i <= 10; i++) {
            areaTabla.append(tablaDada + " x " + i + " = " + (tablaDada * i) + "\n");
        }
    }
}
