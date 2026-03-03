package tarea04;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlBolita extends JFrame implements ActionListener {
    Bolita b;
    JButton btnArriba, btnAbajo, btnDer, btnIzq;

    public ControlBolita() {
        setTitle("Juego Bolita");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        b = new Bolita();
        add(b, BorderLayout.CENTER);

        JPanel pCruceta = new JPanel(new GridLayout(3, 3, 5, 5));

        btnArriba = new JButton("Arriba");
        btnAbajo = new JButton("Abajo");
        btnDer = new JButton("Derecha");
        btnIzq = new JButton("Izquierda");

        btnArriba.addActionListener(this);
        btnAbajo.addActionListener(this);
        btnDer.addActionListener(this);
        btnIzq.addActionListener(this);

        pCruceta.add(new JLabel(""));
        pCruceta.add(btnArriba);
        pCruceta.add(new JLabel(""));

        pCruceta.add(btnIzq);
        pCruceta.add(new JLabel(""));
        pCruceta.add(btnDer);

        pCruceta.add(new JLabel(""));
        pCruceta.add(btnAbajo);
        pCruceta.add(new JLabel(""));

        JPanel panelSur = new JPanel();
        panelSur.add(pCruceta);
        add(panelSur, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        ControlBolita cb = new ControlBolita();
        cb.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDer) {
            b.setMoverX(b.getMoverX() + 10);
        } else if (e.getSource() == btnIzq) {
            b.setMoverX(b.getMoverX() - 10);
        } else if (e.getSource() == btnAbajo) {
            b.setMoverY(b.getMoverY() + 10);
        } else if (e.getSource() == btnArriba) {
            b.setMoverY(b.getMoverY() - 10);
        }
        b.repaint();
    }
}