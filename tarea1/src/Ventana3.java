import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana3 extends JFrame implements ActionListener{
    JTextField numUno, numDos;
    JButton btnOperar;
    JPanel panel01;

    public Ventana3(){
        setTitle("Numero Mayor");
        setSize(400,200);
        setDefaultCloseOperation(3);

        numUno = new JTextField(5);
        numDos = new JTextField(5);
        btnOperar = new JButton("Aceptar");
        btnOperar.addActionListener(this);

        panel01 = new JPanel();

        panel01.add(numUno);
        panel01.add(numDos);
        panel01.add(btnOperar);



        add(panel01);
        setVisible(true);
    }

    public static void main(String[] args) {
        Ventana3 v3 = new Ventana3();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String n1 = numUno.getText();
        String n2 = numDos.getText();

        int uno = Integer.parseInt(n1);
        int dos = Integer.parseInt(n2);

        if(uno>dos){
            JOptionPane.showMessageDialog(null, "Es mayor el" +uno);
        }else{
            JOptionPane.showMessageDialog(null, "Es mayor el" +dos);
        }
    }
}
