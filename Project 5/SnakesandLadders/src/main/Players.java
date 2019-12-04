package main;

import java.util.Queue;
import java.util.LinkedList;

public class Players {
    private Queue<Player> players = new LinkedList<>();

    public void add(Player player) {
        players.add(player);
    }

    public Player remove() {
        if (players.size() > 0) {
            return players.remove();
        }
        return null;
    }
}