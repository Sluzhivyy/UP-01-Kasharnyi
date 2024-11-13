package n8;

import java.awt.*;

public class Rectangle {
    private int x; // Координата X верхнего левого угла
    private int y; // Координата Y верхнего левого угла
    private int width; // Ширина прямоугольника
    private int height; // Высота прямоугольника

    // Конструктор
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Методы для перемещения
    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }

    // Методы для изменения размеров
    public void resize(int newWidth, int newHeight) {
        width = newWidth;
        height = newHeight;
    }

    // Метод для нахождения объединяющего прямоугольника
    public static Rectangle boundingBox(Rectangle r1, Rectangle r2) {
        int minX = Math.min(r1.x, r2.x);
        int minY = Math.min(r1.y, r2.y);
        int maxX = Math.max(r1.x + r1.width, r2.x + r2.width);
        int maxY = Math.max(r1.y + r1.height, r2.y + r2.height);
        return new Rectangle(minX, minY, maxX - minX, maxY - minY);
    }

    // Метод для нахождения пересечения двух прямоугольников
    public static Rectangle intersection(Rectangle r1, Rectangle r2) {
        int interLeft = Math.max(r1.x, r2.x);
        int interTop = Math.max(r1.y, r2.y);
        int interRight = Math.min(r1.x + r1.width, r2.x + r2.width);
        int interBottom = Math.min(r1.y + r1.height, r2.y + r2.height);

        if (interLeft < interRight && interTop < interBottom) {
            return new Rectangle(interLeft, interTop, interRight - interLeft, interBottom - interTop);
        } else {
            return null; // Пересечение отсутствует
        }
    }

    // Метод для отрисовки прямоугольника (можно будет использовать в GUI)
    public void draw(Graphics g) {
        g.drawRect(x, y, width, height);
    }

}


