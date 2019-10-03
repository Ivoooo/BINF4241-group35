import java.util.Stack;

public class Players {
    Stack players = new Stack();

    public boolean add(Player player) {
        players.push(player);
        return true;
    }

    public Player remove() {
        if (!players.empty()) {
            return (Player) players.pop();
        }
        else {
            return null;
        }
    }
}
