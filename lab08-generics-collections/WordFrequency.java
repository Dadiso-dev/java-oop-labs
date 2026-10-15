import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "the cat sat on the mat and the dog sat on the log";

        Map<String, Integer> freq = new HashMap<>();
        for (String w : text.toLowerCase().split("\\s+")) {
            freq.merge(w, 1, Integer::sum);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort((a, b) -> {
            int byCount = b.getValue().compareTo(a.getValue());
            return byCount != 0 ? byCount : a.getKey().compareTo(b.getKey());
        });

        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
}