package n7;

import java.awt.*;
import javax.swing.*;

public class StoveDrawing extends JFrame {

    public StoveDrawing() {
        super("Схематическое изображение плиты");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new StovePanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        new StoveDrawing();
    }
}

class StovePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        int[] xPoints = {50, 150, 150, 50};
        int[] yPoints = {100, 100, 200, 200};
        g.drawPolygon(xPoints, yPoints, 4);
        g.drawLine(50, 100, 50, 200);
        g.drawLine(150, 100, 150, 200);
        g.drawLine(150, 100, 150, 200);
        g.drawRect(50, 100, 100, 20);
        g.drawLine(150, 200, 200, 175);
        g.drawLine(200, 175, 200, 80);
        g.drawLine(200, 80, 150, 100);
        g.drawLine(200, 80, 80, 80);
        g.drawLine(80, 80, 50, 100);
        g.drawLine(50, 100, 50, 200);
        g.drawRect(80, 10, 120, 70);
        g.fillOval(90, 105, 10, 10);
        g.fillOval(100, 105, 10, 10);
        g.fillOval(110, 105, 10, 10);
        g.fillRect(60, 105, 20, 10);
        g.fillOval(125, 83, 30, 15);
        g.fillOval(70, 83, 30, 15);
        g.drawRect(55, 140, 85, 50);
        for (int i = 0; i <= 4; i++) { //Вертикаль
            g.drawLine(55 + i * 20, 140, 50 + i * 20, 190);
        }
        for (int i = 0; i <= 5; i++) { //Горизонт
            g.drawLine(50, 150 + i * 10, 145, 150 + i * 10);
        }


    }
}

