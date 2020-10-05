package lizbyu.design;

import org.junit.Test;

import static org.junit.Assert.*;

public class SnapshotArrayTest {

    @Test
    public void test() {
        SnapshotArray demo = new SnapshotArray(3);
        demo.set(0, 5);
        demo.snap();
        demo.set(0, 6);
        assertEquals(5, demo.get(0, 0));
    }
}