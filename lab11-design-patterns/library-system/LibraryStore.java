import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/** Saves a Library to three CSV files and loads it back. */
public final class LibraryStore {

    private LibraryStore() { }

    public static void save(Library library, Path dir) throws IOException {
        Files.createDirectories(dir);
        Files.write(dir.resolve("items.csv"),
            library.getItems().stream().map(LibraryItem::toCsv).toList());
        Files.write(dir.resolve("members.csv"),
            library.getMembers().stream().map(Member::toCsv).toList());
        Files.write(dir.resolve("loans.csv"),
            library.getMembers().stream()
                .flatMap(m -> m.getLoans().stream())
                .map(Loan::toCsv)
                .toList());
    }

    public static Library load(Path dir) throws IOException {
        Library library = new Library();
        for (String line : readLines(dir.resolve("items.csv"))) {
            library.addItem(parseItem(line));
        }
        for (String line : readLines(dir.resolve("members.csv"))) {
            library.registerMember(Member.fromCsv(line));
        }
        for (String line : readLines(dir.resolve("loans.csv"))) {
            library.restoreLoan(Loan.fromCsv(line));
        }
        return library;
    }

    private static List<String> readLines(Path file) throws IOException {
        if (!Files.exists(file)) {
            return List.of();
        }
        return Files.readAllLines(file).stream().filter(line -> !line.isBlank()).toList();
    }

    private static LibraryItem parseItem(String line) {
        String[] p = line.split(",");
        return switch (p[0]) {
            case "BOOK" -> new Book(p[1], p[2], p[3]);
            case "DVD"  -> new Dvd(p[1], p[2], Integer.parseInt(p[3]));
            default -> throw new IllegalArgumentException("Unknown item type: " + p[0]);
        };
    }
}