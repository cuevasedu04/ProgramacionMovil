package tarea01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ventana2 extends JFrame {
    JButton btnSaludar;

    public Ventana2(){
        setTitle("Saludar");
        setSize(400,400);
        setDefaultCloseOperation(3);

        btnSaludar = new JButton("saludar");

        btnSaludar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Qué oñaaa");
            }
        });

        add(btnSaludar, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Ventana2 v2 = new Ventana2();
        v2.setVisible(true);
    }


}

