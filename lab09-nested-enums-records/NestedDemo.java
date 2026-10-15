import java.util.Iterator;

public class NestedDemo {

    private final int[] data = {10, 20, 30};
    private static int instances = 0;

    NestedDemo() { instances++; }

    static class Helper {
        static String describe() { return "Instances created: " + instances; }
    }

    class DataIterator implements Iterator<Integer> {
        private int index = 0;
        public boolean hasNext() { return index < data.length; }
        public Integer next()    { return data[index++]; }
    }

    public static void main(String[] args) {
        NestedDemo outer = new NestedDemo();
        System.out.println(Helper.describe());

        NestedDemo.DataIterator it = outer.new DataIterator();
        while (it.hasNext()) System.out.print(it.next() + " ");
        System.out.println();

        class Greeter {
            String greet(String n) { return "Hello, " + n; }
        }
        System.out.println(new Greeter().greet("class"));

        Runnable task = new Runnable() {
            @Override public void run() { System.out.println("Anonymous task running"); }
        };
        task.run();

        Runnable lambdaTask = () -> System.out.println("Lambda task running");
        lambdaTask.run();
    }
}