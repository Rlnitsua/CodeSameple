package rlnitsua.array;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MissingNumberTest {
    private final int[] nums;
    private final int res;

    public MissingNumberTest(int[] nums, int res) {
        this.nums = nums;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3,0,1}, },
                {new int[]{}, },
                {new int[]{}, },
                {new int[]{}, },
        });
    }
}