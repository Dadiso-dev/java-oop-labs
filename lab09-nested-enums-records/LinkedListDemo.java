public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("red");
        list.add("green");
        list.add("blue");

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("Size: " + list.size());
    }
}