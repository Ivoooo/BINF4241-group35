package test;

import main.Players;
import main.Player;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the Player Class.
 */
public class TestPlayers {
    /**
     * Tests the add and the remove function.
     * <p>
     * Tests it by
     * - removing on an empty Players list
     * - adding and removing a Player
     * - removing on a Players list that used to have someone
     * </p>
     */
    @Test
    public void addAndRemovePlayer() {
        Players players = new Players();
        Player a = new Player("a");
        Player b;

        //remove empty
        b = players.remove();
        Assert.assertNull(b);

        //basic add and remove
        players.add(a);
        b = players.remove();
        Assert.assertEquals(a,b);

        //remove empty that used to have a player
        b = players.remove();
        Assert.assertNull(b);
    }

    /**
     * Tests the tryMove function.
     * <p>
     * Tests it by
     * - adding multiple player
     * - removing them
     * - adding some again
     * - removing some again
     * </p>
     */
    @Test
    public void multiplePlayer() {
        Players players = new Players();
        Player a = new Player("a");
        Player b = new Player("b");
        Player c = new Player("c");

        players.add(b);
        players.add(a);
        players.add(b);
        players.add(c);

        Player x;
        x = players.remove();
        Assert.assertEquals(x,b);

        x = players.remove();
        Assert.assertEquals(x,a);

        x = players.remove();
        Assert.assertEquals(x,b);

        x = players.remove();
        Assert.assertEquals(x,c);

        x = players.remove();
        Assert.assertNull(x);

        players.add(c);

        x = players.remove();
        Assert.assertEquals(x,c);
    }
}
