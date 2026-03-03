package tarea04;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Bolita extends JPanel {
    private int moverX = 180, moverY = 180;

    public Bolita() {
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(moverX, moverY, 40, 40);
    }

    public int getMoverX() { return moverX; }
    public void setMoverX(int moverX) { this.moverX = moverX; }
    public int getMoverY() { return moverY; }
    public void setMoverY(int moverY) { this.moverY = moverY; }
}