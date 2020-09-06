package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NumberofWaysWhereSquareofNumberIsEqualtoProductofTwoNumbersTest {
    private final int[] nums1;
    private final int[] nums2;
    private final int res;

    public NumberofWaysWhereSquareofNumberIsEqualtoProductofTwoNumbersTest(int[] nums1, int[] nums2, int res) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{7,4}, new int[]{5,2,8,9}, 1},
                {new int[]{1,1}, new int[]{1,1,1}, 9},
                {new int[]{7,7,8,3}, new int[]{1,2,9,7}, 2},
                {new int[]{4,7,9,11,23}, new int[]{3,5,1024,12,18}, 0},
                {new int[]{43024,99908}, new int[]{1864}, 0},
        });
    }

    @Test
    public void test() {
        NumberofWaysWhereSquareofNumberIsEqualtoProductofTwoNumbers demo = new NumberofWaysWhereSquareofNumberIsEqualtoProductofTwoNumbers();
        assertEquals(res, demo.numTriplets(nums1, nums2));
    }
}