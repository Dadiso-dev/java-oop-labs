import java.util.Arrays;

class Player implements Comparable<Player> {
    private final String name;
    private final int score;

    Player(String name, int score) { this.name = name; this.score = score; }

    @Override
    public int compareTo(Player other) {
        return Integer.compare(other.score, this.score);
    }

    @Override
    public String toString() { return name + "(" + score + ")"; }
}

public class ComparableDemo {
    public static void main(String[] args) {
        Player[] players = {
            new Player("Anesu", 70), new Player("Blessing", 95), new Player("Chenai", 82)
        };
        Arrays.sort(players);
        System.out.println(Arrays.toString(players));
    }
}