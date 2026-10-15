abstract class Shape {
    abstract double area();
    abstract double perimeter();
}

class Circle extends Shape {
    private final double r;
    Circle(double r) { this.r = r; }
    @Override double area()      { return Math.PI * r * r; }
    @Override double perimeter() { return 2 * Math.PI * r; }
}

class Rectangle extends Shape {
    private final double w, h;
    Rectangle(double w, double h) { this.w = w; this.h = h; }
    @Override double area()      { return w * h; }
    @Override double perimeter() { return 2 * (w + h); }
}

class Square extends Shape {
    private final double s;
    Square(double s) { this.s = s; }
    @Override double area()      { return s * s; }
    @Override double perimeter() { return 4 * s; }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(3), new Rectangle(4, 5), new Square(2) };
        for (Shape s : shapes) {
            System.out.printf("%-10s area=%.2f perimeter=%.2f%n",
                    s.getClass().getSimpleName(), s.area(), s.perimeter());
        }
    }
}