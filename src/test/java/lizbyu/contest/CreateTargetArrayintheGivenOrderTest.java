package lizbyu.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class CreateTargetArrayintheGivenOrderTest {
    private int[] nums;
    private int[] index;
    private int[] res;

    public CreateTargetArrayintheGivenOrderTest(int[] nums, int[] index, int[] res) {
        this.nums = nums;
        this.index = index;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1}, new int[]{0, 4, 1, 3, 2}},
                {new int[]{1, 2, 3, 4, 0}, new int[]{0, 1, 2, 3, 0}, new int[]{0, 1, 2, 3, 4}}
        });
    }

    @Test
    public void createTargetArray() {
        CreateTargetArrayintheGivenOrder demo = new CreateTargetArrayintheGivenOrder();
        int[] targetArray = demo.createTargetArray(nums, index);
        assertArrayEquals(targetArray, res);
    }
}