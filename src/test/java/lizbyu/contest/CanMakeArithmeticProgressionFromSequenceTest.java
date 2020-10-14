package lizbyu.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CanMakeArithmeticProgressionFromSequenceTest {
    private int[] arr;
    private boolean res;

    public CanMakeArithmeticProgressionFromSequenceTest(int[] arr, boolean res) {
        this.arr = arr;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, 5, 1}, true},
                {new int[]{1, 2, 4}, false}
        });
    }

    @Test
    public void test() {
        CanMakeArithmeticProgressionFromSequence demo = new CanMakeArithmeticProgressionFromSequence();
        assertEquals(res, demo.canMakeArithmeticProgression(arr));
    }
}