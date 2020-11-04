package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ArithmeticSubarraysTest {
    private final int[] nums;
    private final int[] l;
    private final int[] r;
    private final List<Boolean> res;

    public ArithmeticSubarraysTest(int[] nums, int[] l, int[] r, List<Boolean> res) {
        this.nums = nums;
        this.l = l;
        this.r = r;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{4,6,5,9,3,7}, new int[]{0,0,2}, new int[]{2,3,5}, Arrays.asList(true,false,true)},
                {new int[]{-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10},
                        new int[]{0,1,6,4,8,7}, new int[]{4,4,9,7,9,10}, Arrays.asList(false,true,false,false,true,true)},
        });
    }

    @Test
    public void test() {
        ArithmeticSubarrays demo = new ArithmeticSubarrays();
        assertEquals(res, demo.checkArithmeticSubarrays(nums, l, r));
    }
}