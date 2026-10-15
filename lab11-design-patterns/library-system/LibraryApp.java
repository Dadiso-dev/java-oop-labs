import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/** Text menu for the library. Always leave with option 0 so the data is saved. */
public class LibraryApp {

    private static final Path DATA_DIR = Path.of("library-data");

    public static void main(String[] args) {
        Library library = loadLibrary();
        Scanner in = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            String choice = ask(in, "Choose an option: ");
            try {
                switch (choice) {
                    case "1" -> addItem(library, in);
                    case "2" -> registerMember(library, in);
                    case "3" -> borrow(library, in);
                    case "4" -> giveBack(library, in);
                    case "5" -> listOverdue(library, in);
                    case "6" -> search(library, in);
                    case "7" -> listAll(library);
                    case "0" -> running = false;
                    default  -> System.out.println("Please choose 0 to 7.");
                }
            } catch (ItemNotAvailableException | MemberLimitExceededException e) {
                System.out.println("Cannot borrow: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Problem: " + e.getMessage());
            }
        }

        saveLibrary(library);
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("=== Library Menu ===");
        System.out.println("1. Add item");
        System.out.println("2. Register member");
        System.out.println("3. Borrow item");
        System.out.println("4. Return item");
        System.out.println("5. List overdue items");
        System.out.println("6. Search by title");
        System.out.println("7. List all items and members");
        System.out.println("0. Save and exit");
    }

    private static String ask(Scanner in, String prompt) {
        System.out.print(prompt);
        return in.hasNextLine() ? in.nextLine().trim() : "0";
    }

    private static void addItem(Library library, Scanner in) {
        String type = ask(in, "Book or DVD (B/D): ").toUpperCase();
        String id = ask(in, "Item id: ");
        String title = ask(in, "Title: ");
        if (type.equals("B")) {
            library.addItem(new Book(id, title, ask(in, "Author: ")));
        } else if (type.equals("D")) {
            library.addItem(new Dvd(id, title, Integer.parseInt(ask(in, "Minutes: "))));
        } else {
            throw new IllegalArgumentException("Type must be B or D");
        }
        System.out.println("Item added.");
    }

    private static void registerMember(Library library, Scanner in) {
        String id = ask(in, "Member id: ");
        String name = ask(in, "Name: ");
        library.registerMember(new Member(id, name));
        System.out.println("Member registered.");
    }

    private static void borrow(Library library, Scanner in)
            throws ItemNotAvailableException, MemberLimitExceededException {
        String memberId = ask(in, "Member id: ");
        String itemId = ask(in, "Item id: ");
        Loan loan = library.borrow(memberId, itemId);
        System.out.println("Borrowed. Due on " + loan.getDueOn());
    }

    private static void giveBack(Library library, Scanner in) {
        Loan loan = library.giveBack(ask(in, "Item id: "));
        System.out.println("Returned item " + loan.getItemId());
    }

    private static void listOverdue(Library library, Scanner in) {
        int daysAhead = Integer.parseInt(ask(in, "Check overdue how many days from today (0 = today): "));
        List<Loan> overdue = library.listOverdue(LocalDate.now().plusDays(daysAhead));
        if (overdue.isEmpty()) {
            System.out.println("No overdue items.");
        }
        for (Loan loan : overdue) {
            System.out.println(library.getItem(loan.getItemId()).getTitle() + " -> " + loan);
        }
    }

    private static void search(Library library, Scanner in) {
        List<LibraryItem> found = library.searchByTitle(ask(in, "Title contains: "));
        if (found.isEmpty()) {
            System.out.println("No matches.");
        }
        found.forEach(System.out::println);
    }

    private static void listAll(Library library) {
        System.out.println("-- Items --");
        for (LibraryItem item : library.getItems()) {
            System.out.println(item + " | loan period " + item.loanPeriodDays() + " days");
        }
        System.out.println("-- Members --");
        library.getMembers().forEach(System.out::println);
    }

    private static Library loadLibrary() {
        try {
            Library library = LibraryStore.load(DATA_DIR);
            System.out.println("Loaded " + library.getItems().size() + " items and "
                + library.getMembers().size() + " members.");
            return library;
        } catch (IOException | RuntimeException e) {
            System.out.println("Starting with an empty library (" + e.getMessage() + ")");
            return new Library();
        }
    }

    private static void saveLibrary(Library library) {
        try {
            LibraryStore.save(library, DATA_DIR);
            System.out.println("Data saved to " + DATA_DIR + ". Goodbye!");
        } catch (IOException e) {
            System.out.println("Could not save: " + e.getMessage());
        }
    }
}