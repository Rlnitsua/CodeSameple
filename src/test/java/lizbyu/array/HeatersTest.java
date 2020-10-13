package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class HeatersTest {
    private final int[] houses;
    private final int[] heaters;
    private final int res;

    public HeatersTest(int[] houses, int[] heaters, int res) {
        this.houses = houses;
        this.heaters = heaters;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3}, new int[]{2}, 1},
                {new int[]{1,2,3,4}, new int[]{1,4}, 1},
                {new int[]{1,5}, new int[]{2}, 3},
                {new int[]{1,2,3}, new int[]{1}, 2},
        });
    }

    @Test
    public void test() {
        Heaters demo = new Heaters();
        assertEquals(res, demo.findRadius(houses, heaters));
    }
}