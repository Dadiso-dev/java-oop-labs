import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {

    public static final int MAX_LOANS = 3;

    private final String id;
    private final String name;
    private final List<Loan> loans = new ArrayList<>();

    public Member(String id, String name) {
        this.id = Validation.requireText(id, "Member id");
        this.name = Validation.requireText(name, "Name");
    }

    public String getId()   { return id; }
    public String getName() { return name; }

    public List<Loan> getLoans() { return Collections.unmodifiableList(loans); }

    /** Throws if this member already holds the maximum number of loans. */
    void checkCanBorrow() throws MemberLimitExceededException {
        if (loans.size() >= MAX_LOANS) {
            throw new MemberLimitExceededException(
                name + " already has " + MAX_LOANS + " loans (the maximum)");
        }
    }

    void addLoan(Loan loan)    { loans.add(loan); }
    void removeLoan(Loan loan) { loans.remove(loan); }

    public String toCsv() {
        return id + "," + name;
    }

    public static Member fromCsv(String line) {
        String[] p = line.split(",");
        return new Member(p[0], p[1]);
    }

    @Override
    public String toString() {
        return id + ": " + name + " (" + loans.size() + "/" + MAX_LOANS + " loans)";
    }
}