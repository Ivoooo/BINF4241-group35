package test;

import main.Game;
import main.Player;
import org.junit.Assert;
import org.junit.Test;

public class TestGame {
    @Test
    public void IntegrationTest() {
        Game a = new Game(15);

        Player q = new Player("Stephan");
        Player p = new Player("Flavio");
        Player w = new Player("Melanie");

        a.addPlayer(q.getName());
        a.addPlayer(p.getName());
        a.addPlayer(w.getName());

        Assert.assertFalse(a.isFinished());

        while(!a.isFinished()) {
            a.nextTurn();
            Assert.assertTrue(a.getGameBoard().length() >= 30);
        }

        Assert.assertTrue(a.isFinished());
    }
}