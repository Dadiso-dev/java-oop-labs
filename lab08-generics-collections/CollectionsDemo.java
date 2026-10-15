import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Zodwa");
        names.add("Alice");
        names.add("Moyo");
        names.add("Alice");
        System.out.println("List: " + names + " size=" + names.size());
        names.remove("Moyo");
        Collections.sort(names);
        System.out.println("Sorted: " + names);

        Set<String> unique = new TreeSet<>(names);
        System.out.println("Set: " + unique);

        Map<String, Integer> marks = new HashMap<>();
        marks.put("Tino", 78);
        marks.put("Rufaro", 91);
        marks.put("Tino", 82);
        marks.putIfAbsent("Nomsa", 65);

        System.out.println("Tino: " + marks.get("Tino"));
        System.out.println("Has Nomsa? " + marks.containsKey("Nomsa"));

        for (Map.Entry<String, Integer> e : new TreeMap<>(marks).entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        String text = "to be or not to be";
        Map<String, Integer> freq = new TreeMap<>();
        for (String w : text.split(" ")) {
            freq.merge(w, 1, Integer::sum);
        }
        System.out.println(freq);

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1); stack.push(2); stack.push(3);
        System.out.println("Stack pop: " + stack.pop());
        Queue<String> line = new ArrayDeque<>();
        line.offer("first"); line.offer("second");
        System.out.println("Queue poll: " + line.poll());
    }
}