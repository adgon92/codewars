package J003DontGiveMeFive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void exampleTests() {
        assertEquals(8, Kata.dontGiveMeFive(1, 9));
        assertEquals(12, Kata.dontGiveMeFive(4, 37));
        assertEquals(12, Kata.dontGiveMeFive(-17, -4));
        assertEquals(310, Kata.dontGiveMeFive(-400, -27));
    }
}