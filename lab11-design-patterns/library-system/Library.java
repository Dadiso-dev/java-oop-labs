import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** The core service: keeps items and members and enforces the borrowing rules. */
public class Library {

    private final Map<String, LibraryItem> items = new LinkedHashMap<>();
    private final Map<String, Member> members = new LinkedHashMap<>();

    public void addItem(LibraryItem item) {
        if (items.containsKey(item.getId())) {
            throw new IllegalArgumentException("Item id already exists: " + item.getId());
        }
        items.put(item.getId(), item);
    }

    public void registerMember(Member member) {
        if (members.containsKey(member.getId())) {
            throw new IllegalArgumentException("Member id already exists: " + member.getId());
        }
        members.put(member.getId(), member);
    }

    public Collection<LibraryItem> getItems() {
        return Collections.unmodifiableCollection(items.values());
    }

    public Collection<Member> getMembers() {
        return Collections.unmodifiableCollection(members.values());
    }

    public LibraryItem getItem(String id) {
        LibraryItem item = items.get(id);
        if (item == null) {
            throw new IllegalArgumentException("No such item: " + id);
        }
        return item;
    }

    public Member getMember(String id) {
        Member member = members.get(id);
        if (member == null) {
            throw new IllegalArgumentException("No such member: " + id);
        }
        return member;
    }

    public Loan borrow(String memberId, String itemId)
            throws ItemNotAvailableException, MemberLimitExceededException {
        Member member = getMember(memberId);
        LibraryItem item = getItem(itemId);

        member.checkCanBorrow();
        item.borrow(member);

        Loan loan = Loan.start(itemId, memberId, item.loanPeriodDays());
        member.addLoan(loan);
        return loan;
    }

    public Loan giveBack(String itemId) {
        LibraryItem item = getItem(itemId);
        for (Member member : members.values()) {
            for (Loan loan : member.getLoans()) {
                if (loan.getItemId().equals(itemId)) {
                    member.removeLoan(loan);
                    item.giveBack();
                    return loan;
                }
            }
        }
        throw new IllegalArgumentException(item.getTitle() + " is not on loan");
    }

    public List<Loan> listOverdue(LocalDate asOf) {
        return members.values().stream()
            .flatMap(m -> m.getLoans().stream())
            .filter(loan -> loan.isOverdue(asOf))
            .sorted(Comparator.comparing(Loan::getDueOn))
            .toList();
    }

    public List<LibraryItem> searchByTitle(String text) {
        return items.values().stream()
            .filter(i -> i.getTitle().toLowerCase().contains(text.toLowerCase()))
            .sorted(Comparator.comparing(LibraryItem::getTitle))
            .toList();
    }

    /** Used when loading from disk: re-attaches a saved loan without the usual checks. */
    void restoreLoan(Loan loan) {
        getMember(loan.getMemberId()).addLoan(loan);
        getItem(loan.getItemId()).setAvailable(false);
    }
}