import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;

/** A scripted run that shows every requirement working, with no typing needed. */
public class LibraryDemo {

    public static void main(String[] args) throws IOException {
        Library library = new Library();
        library.addItem(new Book("B1", "Clean Code", "Robert Martin"));
        library.addItem(new Book("B2", "Effective Java", "Joshua Bloch"));
        library.addItem(new Book("B3", "Java Concurrency", "Brian Goetz"));
        library.addItem(new Dvd("D1", "Inside Java", 90));
        library.registerMember(new Member("M1", "Tendai"));
        library.registerMember(new Member("M2", "Chipo"));

        System.out.println("-- Polymorphism: each item has its own loan period --");
        for (LibraryItem item : library.getItems()) {
            System.out.println(item.getTitle() + ": " + item.loanPeriodDays() + " days");
        }

        System.out.println("-- Borrowing --");
        try {
            library.borrow("M1", "B1");
            library.borrow("M1", "B2");
            library.borrow("M1", "B3");
            System.out.println("M1 borrowed three items");
            library.borrow("M1", "D1");
        } catch (ItemNotAvailableException | MemberLimitExceededException e) {
            System.out.println("Limit rule: " + e.getMessage());
        }
        try {
            library.borrow("M2", "B1");
        } catch (ItemNotAvailableException | MemberLimitExceededException e) {
            System.out.println("Availability rule: " + e.getMessage());
        }

        System.out.println("-- Search (streams) --");
        library.searchByTitle("java").forEach(System.out::println);

        System.out.println("-- Overdue --");
        System.out.println("Today: " + library.listOverdue(LocalDate.now()).size());
        System.out.println("In 20 days: " + library.listOverdue(LocalDate.now().plusDays(20)).size());

        System.out.println("-- Persistence --");
        Path dir = Path.of("demo-data");
        LibraryStore.save(library, dir);
        Library reloaded = LibraryStore.load(dir);
        System.out.println("Reloaded items: " + reloaded.getItems().size());
        System.out.println("Reloaded B1 available? " + reloaded.getItem("B1").isAvailable());
        System.out.println("Reloaded D1 available? " + reloaded.getItem("D1").isAvailable());
        System.out.println("Reloaded " + reloaded.getMember("M1"));

        System.out.println("-- Return --");
        reloaded.giveBack("B1");
        System.out.println("B1 available again? " + reloaded.getItem("B1").isAvailable());
        System.out.println(reloaded.getMember("M1"));
    }
}