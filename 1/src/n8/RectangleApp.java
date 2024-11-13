package n8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RectangleApp extends JPanel {
    private Rectangle rect1;
    private Rectangle rect2;

    public RectangleApp() {
        // Пример прямоугольников
        rect1 = new Rectangle(50, 50, 100, 50);
        rect2 = new Rectangle(120, 80, 60, 100);

        // Добавление обработчика мыши для перемещения прямоугольников
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    rect1.move(10, 10); // Пример перемещения прямоугольника
                    repaint();
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    rect2.move(-10, -10); // Перемещение второго прямоугольника
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        rect1.draw(g);
        rect2.draw(g);

        // Отрисовка объединяющего прямоугольника
        Rectangle boundingBox = Rectangle.boundingBox(rect1, rect2);
        if (boundingBox != null) {
            g.setColor(Color.GRAY);
            boundingBox.draw(g);
        }

        // Отрисовка пересечения
        Rectangle intersection = Rectangle.intersection(rect1, rect2);
        if (intersection != null) {
            g.setColor(Color.RED);
            intersection.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rectangle App");
        RectangleApp app = new RectangleApp();

        frame.add(app);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
