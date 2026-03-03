package tarea05;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CalculadoraGrafica extends JFrame {
    JTextField n1, n2;
    JButton btnSum, btnRes, btnDiv, btnMul;
    JLabel txtRes;
    Font fuente = new Font("Courier", Font.BOLD, 60);
    Calculadora calc = new Calculadora();

    public CalculadoraGrafica() {
        setTitle("Mi Casio Mejorada");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(4, 1, 15, 15));
        panelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelPrincipal.setBackground(new Color(240, 245, 250));

        n1 = new JTextField();
        n1.setFont(fuente);
        n1.setHorizontalAlignment(JTextField.CENTER);

        n2 = new JTextField();
        n2.setFont(fuente);
        n2.setHorizontalAlignment(JTextField.CENTER);

        JPanel pOpciones = new JPanel(new GridLayout(1, 4, 10, 10));
        pOpciones.setBackground(new Color(240, 245, 250));

        btnSum = new JButton("+");
        btnRes = new JButton("-");
        btnMul = new JButton("*");
        btnDiv = new JButton("/");

        estilizarBoton(btnSum);
        estilizarBoton(btnRes);
        estilizarBoton(btnMul);
        estilizarBoton(btnDiv);

        pOpciones.add(btnSum);
        pOpciones.add(btnRes);
        pOpciones.add(btnMul);
        pOpciones.add(btnDiv);

        txtRes = new JLabel("0", JLabel.CENTER);
        txtRes.setFont(new Font("Courier", Font.BOLD, 70));
        txtRes.setForeground(new Color(34, 139, 34));

        btnSum.addActionListener(e -> realizarOperacion("+"));
        btnRes.addActionListener(e -> realizarOperacion("-"));
        btnMul.addActionListener(e -> realizarOperacion("*"));
        btnDiv.addActionListener(e -> realizarOperacion("/"));

        panelPrincipal.add(n1);
        panelPrincipal.add(n2);
        panelPrincipal.add(pOpciones);
        panelPrincipal.add(txtRes);
        add(panelPrincipal);
    }

    private void estilizarBoton(JButton btn) {
        btn.setFont(fuente);
        btn.setBackground(new Color(50, 50, 50));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
    }

    private void realizarOperacion(String operacion) {
        try {
            double num1 = Double.parseDouble(n1.getText());
            double num2 = Double.parseDouble(n2.getText());
            double resultado = 0;

            switch (operacion) {
                case "+": resultado = calc.sumar(num1, num2); break;
                case "-": resultado = calc.restar(num1, num2); break;
                case "*": resultado = Calculadora.multiplicar(num1, num2); break;
                case "/": resultado = Calculadora.dividir(num1, num2); break;
            }

            txtRes.setText(String.valueOf(resultado));

        } catch (NumberFormatException ex) {
            txtRes.setText("Error");
        }
    }

    public static void main(String[] args) {
        CalculadoraGrafica cc = new CalculadoraGrafica();
        cc.setVisible(true);
    }
}