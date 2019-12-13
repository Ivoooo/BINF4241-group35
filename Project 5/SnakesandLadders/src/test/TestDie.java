package test;

import org.junit.Assert;
import org.junit.Test;
import main.Die;

/**
 * Tests the Die Class.
 */
public class TestDie {

    @Test
    public void rollInRange() {
        Die a = new Die();
        int b;
        for(int i = 0; i < 100; ++i) {
            b = a.rollDie();
            Assert.assertFalse(b < 1 || b > 6);
        }
    }
}
