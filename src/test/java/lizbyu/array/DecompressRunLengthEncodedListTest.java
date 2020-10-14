package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class DecompressRunLengthEncodedListTest {
    private int[] nums;
    private int[] res;

    public DecompressRunLengthEncodedListTest(int[] nums, int[] res) {
        this.nums = nums;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4}, new int[]{2, 4, 4, 4}},
                {new int[]{1, 1, 2, 3}, new int[]{1, 3, 3}}
        });
    }

    @Test
    public void decompressRLElist() {
        DecompressRunLengthEncodedList demo = new DecompressRunLengthEncodedList();
        assertArrayEquals(res, demo.decompressRLElist(nums));
    }
}