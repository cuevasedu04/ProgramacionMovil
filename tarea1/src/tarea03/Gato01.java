package tarea03;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Gato01 extends JFrame implements ActionListener {
    JButton botones [] = new JButton[9];
    JButton btnReinciar;
    boolean turnoX=true;
    Font fuente = new Font("Arial",1,60);
    JPanel pJuego, pOpciones;
    String letra;

    public Gato01(){
        setTitle("Gato");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //pJuego = new JPanel(new GridLayout(3,3));
        pJuego = new JPanel();
        pJuego.setLayout(new GridLayout(3,3));

        //botones[0] = new JButton("");
        //pJuego.add(botones[0]);

        for(int i=0;i<botones.length;i++){
            botones[i] = new JButton("");
            botones[i].setFont(fuente);
            botones[i].addActionListener(this);
            pJuego.add(botones[i]);
        }

        add(pJuego, BorderLayout.CENTER);


        btnReinciar = new JButton("Reiniciar Juego");
        pOpciones = new JPanel();

        btnReinciar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ex){
                for(int i=0;i<botones.length;i++){
                    botones[i].setText("");
                    botones[i].setEnabled(true);
                }
                turnoX=true;
            }
        });

        pOpciones.add(btnReinciar);
        add(pOpciones, BorderLayout.SOUTH);
    }

    public static void main(String a []){
        Gato01 g01 = new Gato01();
        g01.setVisible(true);
    }

    // metodo para validar el ganador
    public void validarGanador() {
        int[][] combinaciones = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Horizontales
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Verticales
                {0, 4, 8}, {2, 4, 6}             // Diagonales
        };

        for (int[] c : combinaciones) {
            if (!botones[c[0]].getText().equals("") &&
                    botones[c[0]].getText().equals(botones[c[1]].getText()) &&
                    botones[c[0]].getText().equals(botones[c[2]].getText())) {

                JOptionPane.showMessageDialog(this, "Ganó " + botones[c[0]].getText() );
                bloquearBotones();
                return;
            }
        }
    }

    // Bloquea el tablero al terminar el juego
    public void bloquearBotones() {
        for (JButton b : botones) b.setEnabled(false);
    }

    public void actionPerformed(ActionEvent btnApretado){
        if(turnoX){
            letra="X";
            turnoX=false;
        }else{
            letra="O";
            turnoX=true;
        }

        for(int i=0;i<botones.length;i++){
            if(btnApretado.getSource()==botones[i]){
                botones[i].setText(letra);
                botones[i].setEnabled(false);
                validarGanador();
            }
        }
    }
}
