public class Rectangle {
    double width;
    double height;

    double area() {
        return width * height;
    }

    double perimeter() {
        return 2 * (width + height);
    }

    public static void main(String[] args) {
        // Step 1: make the array (5 empty slots)
        Rectangle[] rects = new Rectangle[5];

        // Step 2: fill it with 5 different rectangles
        for (int i = 0; i < rects.length; i++) {
            rects[i] = new Rectangle();
            rects[i].width = i + 2;
            rects[i].height = i + 3;
        }

        // Step 3: find the rectangle with the largest area
        Rectangle largest = rects[0];
        for (int i = 1; i < rects.length; i++) {
            if (rects[i].area() > largest.area()) {
                largest = rects[i];
            }
        }

        // Step 4: print the result
        System.out.println("Largest: " + largest.width + " x " + largest.height);
        System.out.println("Area: " + largest.area());
        System.out.println("Perimeter: " + largest.perimeter());
    }
}






