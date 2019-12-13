package test;

import main.Players;
import main.Player;
import org.junit.Assert;
import org.junit.Test;

public class TestPlayers {
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
