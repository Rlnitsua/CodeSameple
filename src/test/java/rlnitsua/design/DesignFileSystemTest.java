package rlnitsua.design;

import org.junit.Test;

import static org.junit.Assert.*;

public class DesignFileSystemTest {
    @Test
    public void test() {
        DesignFileSystem demo = new DesignFileSystem();
        assertTrue(demo.createPath("/leet", 1));
        assertTrue(demo.createPath("/leet/code", 2));
        assertEquals(2, demo.get("/leet/code"));
        assertFalse(demo.createPath("/c/d", 1));
        assertEquals(-1, demo.get("/c"));
    }

}