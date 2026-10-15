import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class TextStats {
    public static void main(String[] args) {
        Path path = Path.of("sample.txt");

        try {
            Files.write(path, List.of(
                "The quick brown fox",
                "jumps over the lazy dog",
                "Java makes files easy"));

            List<String> lines = Files.readAllLines(path);
            int words = 0;
            int chars = 0;
            for (String line : lines) {
                if (!line.isBlank()) {
                    words += line.trim().split("\\s+").length;
                }
                chars += line.length();
            }

            System.out.println("Lines: " + lines.size());
            System.out.println("Words: " + words);
            System.out.println("Characters: " + chars);
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}