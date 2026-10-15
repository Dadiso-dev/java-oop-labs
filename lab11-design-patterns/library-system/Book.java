public class Book extends LibraryItem {

    private final String author;

    public Book(String id, String title, String author) {
        super(id, title);
        this.author = Validation.requireText(author, "Author");
    }

    public String getAuthor() { return author; }

    @Override
    public int loanPeriodDays() { return 14; }

    @Override
    public String toCsv() {
        return "BOOK," + getId() + "," + getTitle() + "," + author;
    }

    @Override
    public String toString() {
        return "Book " + getId() + ": " + getTitle() + " by " + author + " " + status();
    }
}