import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private final List<String> members = new ArrayList<>();

    public void addMember(String name) { members.add(name); }

    public List<String> getMembersUnsafe() { return members; }

    public List<String> getMembers() { return Collections.unmodifiableList(members); }

    public static void main(String[] args) {
        Team t = new Team();
        t.addMember("Chipo");

        t.getMembersUnsafe().clear();
        System.out.println("After unsafe clear: " + t.getMembers().size());

        t.addMember("Chipo");
        try {
            t.getMembers().clear();
        } catch (UnsupportedOperationException e) {
            System.out.println("Safe getter blocked modification");
        }
    }
}