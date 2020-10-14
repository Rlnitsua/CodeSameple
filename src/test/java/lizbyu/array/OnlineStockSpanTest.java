package lizbyu.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OnlineStockSpanTest {

    @Test
    public void test() {
        OnlineStockSpan demo = new OnlineStockSpan();
        assertEquals(1, demo.next(100));
        assertEquals(1, demo.next(80));
        assertEquals(1, demo.next(60));
        assertEquals(2, demo.next(70));
        assertEquals(1, demo.next(60));
        assertEquals(4, demo.next(75));
        assertEquals(6, demo.next(85));
    }
}