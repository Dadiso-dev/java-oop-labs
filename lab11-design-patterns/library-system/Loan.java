import java.time.LocalDate;

/** A record of one item being borrowed by one member. */
public final class Loan {

    private final String itemId;
    private final String memberId;
    private final LocalDate borrowedOn;
    private final LocalDate dueOn;

    public Loan(String itemId, String memberId, LocalDate borrowedOn, LocalDate dueOn) {
        if (dueOn.isBefore(borrowedOn)) {
            throw new IllegalArgumentException("Due date cannot be before the borrow date");
        }
        this.itemId = itemId;
        this.memberId = memberId;
        this.borrowedOn = borrowedOn;
        this.dueOn = dueOn;
    }

    /** Starts a loan today for the given number of days. */
    public static Loan start(String itemId, String memberId, int days) {
        LocalDate today = LocalDate.now();
        return new Loan(itemId, memberId, today, today.plusDays(days));
    }

    public String getItemId()   { return itemId; }
    public String getMemberId() { return memberId; }
    public LocalDate getDueOn() { return dueOn; }

    public boolean isOverdue(LocalDate asOf) {
        return asOf.isAfter(dueOn);
    }

    public String toCsv() {
        return itemId + "," + memberId + "," + borrowedOn + "," + dueOn;
    }

    public static Loan fromCsv(String line) {
        String[] p = line.split(",");
        return new Loan(p[0], p[1], LocalDate.parse(p[2]), LocalDate.parse(p[3]));
    }

    @Override
    public String toString() {
        return "Item " + itemId + " held by " + memberId + ", due " + dueOn;
    }
}