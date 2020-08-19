package lizbyu.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class RLEIteratorTest {

    @Test
    public void test() {
        int[] A = new int[]{3, 8, 0, 9, 2, 5};
        RLEIterator rleIterator = new RLEIterator(A);
        assertEquals(8, rleIterator.next(2));
        assertEquals(8, rleIterator.next(1));
        assertEquals(5, rleIterator.next(1));
        assertEquals(-1, rleIterator.next(2));
    }
}