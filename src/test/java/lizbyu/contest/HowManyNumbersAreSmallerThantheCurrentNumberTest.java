package lizbyu.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class HowManyNumbersAreSmallerThantheCurrentNumberTest {
    private int[] nums;
    private int[] res;

    public HowManyNumbersAreSmallerThantheCurrentNumberTest(int[] nums, int[] res) {
        this.nums = nums;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> preparedData() {
        return Arrays.asList(new Object[][]{
                {new int[]{8, 1, 2, 2, 3}, new int[]{4, 0, 1, 1, 3}},
                {new int[]{6, 5, 4, 8}, new int[]{2, 1, 0, 3}},
                {new int[]{7, 7, 7, 7}, new int[]{0, 0, 0, 0}}
        });
    }

    @Test
    public void smallerNumbersThanCurrent() {
        HowManyNumbersAreSmallerThantheCurrentNumber number = new HowManyNumbersAreSmallerThantheCurrentNumber();
        assertArrayEquals(number.smallerNumbersThanCurrent(nums), res);
    }
}