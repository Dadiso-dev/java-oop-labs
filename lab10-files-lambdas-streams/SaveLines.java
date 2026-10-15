import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class SaveLines {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            System.out.print("Line " + i + ": ");
            lines.add(in.nextLine());
        }

        Path path = Path.of("notes.txt");
        try {
            Files.write(path, lines);
            System.out.println("Saved to " + path);
            System.out.println("--- Reading back ---");
            for (String line : Files.readAllLines(path)) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}