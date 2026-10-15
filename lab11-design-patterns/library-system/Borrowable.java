/** Anything in the library that a member can borrow and give back. */
public interface Borrowable {

    void borrow(Member member) throws ItemNotAvailableException;

    void giveBack();
}