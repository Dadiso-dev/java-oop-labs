/** Base class for everything the library lends out. */
public abstract class LibraryItem implements Borrowable {

    private final String id;
    private final String title;
    private boolean available = true;

    protected LibraryItem(String id, String title) {
        this.id = Validation.requireText(id, "Item id");
        this.title = Validation.requireText(title, "Title");
    }

    /** Each kind of item has its own loan period (polymorphism). */
    public abstract int loanPeriodDays();

    /** One CSV line describing this item, used when saving. */
    public abstract String toCsv();

    public String getId()        { return id; }
    public String getTitle()     { return title; }
    public boolean isAvailable() { return available; }

    void setAvailable(boolean available) { this.available = available; }

    @Override
    public void borrow(Member member) throws ItemNotAvailableException {
        if (!available) {
            throw new ItemNotAvailableException(title + " is already on loan");
        }
        available = false;
    }

    @Override
    public void giveBack() {
        available = true;
    }

    protected String status() {
        return available ? "[available]" : "[on loan]";
    }
}