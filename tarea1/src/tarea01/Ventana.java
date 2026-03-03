package tarea01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener{
    int ancho, alto;
    JTextField txtEdad;
    JButton btnAceptar;
    JPanel panelBotones;

    public Ventana(){
        ancho = 400;
        alto=400;
        setTitle("Mi tarea01.Ventana");
        setSize(ancho, alto);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelBotones = new JPanel();
        txtEdad = new JTextField(5);
        btnAceptar = new JButton("Escribe tu edad");

        btnAceptar.addActionListener(this);

        panelBotones.add(txtEdad);
        panelBotones.add(btnAceptar);


        add(panelBotones);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int edad = Integer.parseInt(txtEdad.getText());

            if (edad >= 18) {
                JOptionPane.showMessageDialog(this, "Eres mayor de edad");
            } else if (edad >= 0) {
                JOptionPane.showMessageDialog(this, "Eres menor de edad");
            } else {
                JOptionPane.showMessageDialog(this, "Ingresa una edad valida");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingresa un numero valido.");
        }
    }

    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }

}



/// Hacer la logica para que diga si eres mayor de edad, para el 20 de marzo todos los programas que vayan dejando.

/// 1.- tarea01.Ventana de mayor de edad

