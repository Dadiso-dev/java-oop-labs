import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Point {
    private final int x, y;
    Point(int x, int y) { this.x = x; this.y = y; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point other)) return false;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() { return Objects.hash(x, y); }

    @Override
    public String toString() { return "Point(" + x + ", " + y + ")"; }
}

record Coordinate(int x, int y) {
    Coordinate {
        if (x < 0 || y < 0) throw new IllegalArgumentException("Negative coordinate");
    }
    double distanceFromOrigin() { return Math.sqrt(x * x + y * y); }
}

public class ObjectContract {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

        Set<Point> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        System.out.println("Set size: " + set.size());
        System.out.println(p1);

        Coordinate c1 = new Coordinate(3, 4);
        Coordinate c2 = new Coordinate(3, 4);
        System.out.println(c1);
        System.out.println(c1.equals(c2));
        System.out.println(c1.x() + " " + c1.distanceFromOrigin());
    }
}