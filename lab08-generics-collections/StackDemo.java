public class StackDemo {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("a");
        s.push("b");
        s.push("c");

        System.out.println("Peek: " + s.peek());
        System.out.println("Pop: " + s.pop());
        System.out.println("Pop: " + s.pop());
        System.out.println("Empty? " + s.isEmpty());
        s.pop();
        System.out.println("Empty? " + s.isEmpty());

        try {
            s.pop();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}