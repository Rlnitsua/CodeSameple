package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LemonadeChangeTest {
    private final int[] bills;
    private final boolean res;

    public LemonadeChangeTest(int[] bills, boolean res) {
        this.bills = bills;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{5,5,5,10,20}, true},
                {new int[]{5,5,10}, true},
                {new int[]{10,10}, false},
                {new int[]{5,5,10,10,20}, false},
        });
    }

    @Test
    public void test() {
        LemonadeChange demo = new LemonadeChange();
        assertEquals(res, demo.lemonadeChange(bills));
    }
}