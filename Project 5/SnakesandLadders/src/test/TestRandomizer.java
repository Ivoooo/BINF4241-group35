package test;

import org.junit.Assert;
import org.junit.Test;
import main.Randomizer;

public class TestRandomizer {
    @Test
    public void generatePositiveNumber() {
        for(int i = 0; i < 100; ++i) {
            int b = Randomizer.generate(1, 10);
            Assert.assertFalse(b < 1 || b > 10);

            int c = Randomizer.generate(10, 1);
            Assert.assertFalse(c < 1 || c > 10);
        }
    }

    @Test
    public void generateNegativeNumber() {
        for(int i = 0; i < 100; ++i) {
            int b = Randomizer.generate(-10, -2);
            Assert.assertFalse(b < -10 || b > -2);

            int c = Randomizer.generate(-2, -10);
            Assert.assertFalse(c < -10 || c > -2);
        }
    }

    @Test
    public void generateFullRange() {
        for(int i = 0; i < 100; ++i) {
            int b = Randomizer.generate(-10, 10);
            Assert.assertFalse(b < -10 || b > 10);

            int c = Randomizer.generate(10, -10);
            Assert.assertFalse(c < -10 || c > 10);
        }
    }
}