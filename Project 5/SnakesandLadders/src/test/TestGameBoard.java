package test;

import main.Player;
import main.GameBoard;
import org.junit.Assert;
import org.junit.Test;

public class TestGameBoard {

    @Test
    public void isGameOver() {
        GameBoard a = new GameBoard(15);
        Player b = new Player("Peter");

        a.place("Peter");
        Assert.assertFalse(a.isGameOver());

        a.move(b, 14);
        Assert.assertTrue(a.isGameOver());
    }

    @Test
    public void place() {
        GameBoard a = new GameBoard(15);
        a.place("Peter");
        a.place("Michael");
        a.place("Peter");
    }

    @Test
    public void move() {
        GameBoard a = new GameBoard(15);
        Player b = new Player("Peter");
        Player c = new Player("Michael");
        Player d = new Player("Anna");

        a.place(b.getName());
        a.place(c.getName());
        a.place(d.getName());

        Assert.assertNull(a.move(b, -4));

        b = a.move(b, 4);
        c = a.move(c, 5);
        d = a.move(d, 6);

        //there are 1 snake and 1 ladder so one at least find it's intended position
        Assert.assertTrue(b.getPosition() == 4 || c.getPosition() == 5 || d.getPosition() == 6);
    }
}
