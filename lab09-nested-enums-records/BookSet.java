import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book {
    private final String isbn;
    private final String title;

    Book(String isbn, String title) { this.isbn = isbn; this.title = title; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book other)) return false;
        return isbn.equals(other.isbn);
    }

    @Override
    public int hashCode() { return Objects.hash(isbn); }

    @Override
    public String toString() { return title + " [" + isbn + "]"; }
}

public class BookSet {
    public static void main(String[] args) {
        Set<Book> shelf = new HashSet<>();
        System.out.println(shelf.add(new Book("111", "Clean Code")));
        System.out.println(shelf.add(new Book("222", "Effective Java")));
        System.out.println(shelf.add(new Book("111", "Clean Code (copy)")));
        System.out.println("Size: " + shelf.size());
    }
}