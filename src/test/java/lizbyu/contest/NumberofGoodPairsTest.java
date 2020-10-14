package lizbyu.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NumberofGoodPairsTest {
    private int[] nums;
    private int res;

    public NumberofGoodPairsTest(int[] nums, int res) {
        this.nums = nums;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 1, 1, 3}, 4},
                {new int[]{1, 1, 1, 1}, 6},
                {new int[]{1, 2, 3}, 0}
        });
    }

    @Test
    public void test() {
        NumberofGoodPairs demo = new NumberofGoodPairs();
        assertEquals(res, demo.numIdenticalPairs(nums));
    }
}