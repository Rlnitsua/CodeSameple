package rlnitsua.design;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {

    @Test
    public void test() {
        LRUCache demo = new LRUCache(2);
        assertEquals(-1, demo.get(2));
        demo.put(2, 6);
        assertEquals(-1, demo.get(1));
        demo.put(1, 5);
        demo.put(1, 2);
        assertEquals(2, demo.get(1));
        assertEquals(6, demo.get(2));
    }
}