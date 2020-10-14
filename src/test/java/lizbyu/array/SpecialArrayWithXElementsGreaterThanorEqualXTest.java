package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SpecialArrayWithXElementsGreaterThanorEqualXTest {
    private final int[] nums;
    private final int res;

    public SpecialArrayWithXElementsGreaterThanorEqualXTest(int[] nums, int res) {
        this.nums = nums;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, 5}, 2},
                {new int[]{0, 0}, -1},
                {new int[]{0, 4, 3, 0, 4}, 3},
                {new int[]{3, 6, 7, 7, 0}, -1},
        });
    }

    @Test
    public void test() {
        SpecialArrayWithXElementsGreaterThanorEqualX demo = new SpecialArrayWithXElementsGreaterThanorEqualX();
        assertEquals(res, demo.specialArray(nums));
    }
}