package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CheckIfaNumberIsMajorityElementinaSortedArrayTest {
    private final int[] nums;
    private final int target;
    private final boolean res;

    public CheckIfaNumberIsMajorityElementinaSortedArrayTest(int[] nums, int target, boolean res) {
        this.nums = nums;
        this.target = target;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2,4,5,5,5,5,5,6,6}, 5, true},
                {new int[]{10,100,101,101}, 101, false},
        });
    }

    @Test
    public void test() {
        CheckIfaNumberIsMajorityElementinaSortedArray demo = new CheckIfaNumberIsMajorityElementinaSortedArray();
        assertEquals(res, demo.isMajorityElement(nums, target));
    }
}