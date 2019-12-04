package test;

import org.junit.Assert;
import org.junit.Test;
import main.Die;

public class TestDie {
    @Test
    public void rollInRange() {
        Die a = new Die();
        int b = a.rollDie();
        for(int i = 0; i < 100; ++i) {
            Assert.assertFalse(b < 1 || b > 6);
        }
    }
}
