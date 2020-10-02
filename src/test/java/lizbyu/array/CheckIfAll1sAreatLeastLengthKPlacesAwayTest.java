package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CheckIfAll1sAreatLeastLengthKPlacesAwayTest {
    private final int[] nums;
    private final int k;
    private final boolean res;

    public CheckIfAll1sAreatLeastLengthKPlacesAwayTest(int[] nums, int k, boolean res) {
        this.nums = nums;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,0,0,0,1,0,0,1}, 2, true},
                {new int[]{1,0,0,1,0,1}, 2, false},
                {new int[]{1,1,1,1,1}, 0, true},
                {new int[]{0,1,0,1}, 1, true},
        });
    }

    @Test
    public void test() {
        CheckIfAll1sAreatLeastLengthKPlacesAway demo = new CheckIfAll1sAreatLeastLengthKPlacesAway();
        assertEquals(res, demo.kLengthApart(nums, k));
    }
}