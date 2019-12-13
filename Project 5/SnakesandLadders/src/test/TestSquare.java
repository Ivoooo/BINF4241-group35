package test;

import main.Square;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the Square Class.
 */
public class TestSquare {
    /**
     * Tests the tryMove function.
     * <p>
     * Tests it by
     * - Moving normally
     * - Moving normally with a different Player
     * - Moving on a Shortcut.
     * </p>
     */
    @Test
    public void tryMove() {
        Square a = new Square();
        Boolean res = a.tryMove("Peter");
        Assert.assertTrue(res);

        res = a.tryMove("Stephan");
        Assert.assertTrue(res);

        Square b = new Square();
        b.makeShortcut(5, "SNAKE");
        res = b.tryMove("Peter");
        Assert.assertFalse(res);
    }

    /**
     * Tests the isOccupied function.
     * <p>
     * Tests it by
     * - Checking when it's true
     * - Checking when it should be false
     * </p>
     */
    @Test
    public void isOccupied() {
        Square a = new Square();
        Assert.assertFalse(a.isOccupied());

        a.tryMove("Peter");
        Assert.assertTrue(a.isOccupied());
    }

    /**
     * Tests the makeShortcut function.
     * <p>
     * Tests it by
     * - Creating a normal Snake
     * - Creating a normal Ladder
     * - Creating a shortcut to the Start
     * - Creating an undefinded shortcut
     * - Creating a shortcut to a wrong position
     * </p>
     */
    @Test
    public void makeShortcut() {
        Square a = new Square();
        a.makeShortcut(5, "SNAKE");
        Assert.assertEquals(a.getDestination(), 5);

        a.makeShortcut(6, "LADDER");
        Assert.assertEquals(a.getDestination(), 6);

        a.makeShortcut(0, "LADDER");
        Assert.assertEquals(a.getDestination(), 0);

        a.makeShortcut(7, "XXX");
        Assert.assertEquals(a.getDestination(), 7);

        a.makeShortcut(-5, "SNAKE");
        Assert.assertEquals(a.getDestination(), 7);

    }

    /**
     * Tests the leave function.
     * <p>
     * Tests it by
     * - Moving and leaving 1 Person
     * - Moving and leaving with multiple People
     * - Moving and leaving with people with the same name
     * </p>
     */
    @Test
    public void leave() {
        Square a = new Square();
        //leave empty square
        a.leave("a");

        //leave multiple, some identical members
        a.tryMove("Peter");
        a.tryMove("Michael");
        a.tryMove("Peter");

        a.leave("Peter");
        a.leave("Michael");
        Boolean x = a.isOccupied();
        Assert.assertTrue(x);

        a.leave("Peter");
        x = a.isOccupied();
        Assert.assertFalse(x);
    }

    /**
     * Tests the repr function.
     * <p>
     * Tests it by
     * - Checking on a normal Tile
     * - The Start Tile
     * - On a Ladder
     * - On a Snake
     * - On a Tile with 1 Person
     * - On a Tile with multiple People
     * </p>
     */
    @Test
    public void repr() {
        //proper standard inputs
        Square a = new Square();
        Assert.assertEquals(a.repr(5), "[6]");

        a = new Square();
        Assert.assertEquals(a.repr(0), "[1]");

        //wrong input
        a = new Square();
        Assert.assertNull(a.repr(-5));

        //shortcuts
        a.makeShortcut(11, "LADDER");
        Assert.assertEquals(a.repr(5), "[6->12]");

        a.makeShortcut(4, "SNAKE");
        Assert.assertEquals(a.repr(10), "[5<-11]");

        //with players
        a = new Square();
        a.tryMove("Peter");
        Assert.assertEquals(a.repr(5), "[6<Peter>]");

        a.tryMove("Michael");
        Assert.assertEquals(a.repr(7), "[8<Peter><Michael>]");
    }
}
