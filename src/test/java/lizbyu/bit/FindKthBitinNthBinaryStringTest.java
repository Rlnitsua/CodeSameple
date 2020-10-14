package lizbyu.bit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FindKthBitinNthBinaryStringTest {
    private int n;
    private int k;
    private char res;

    public FindKthBitinNthBinaryStringTest(int n, int k, char res) {
        this.n = n;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3, 1, '0'},
                {4, 11, '1'},
                {1, 1, '0'},
                {2, 3, '1'},
        });
    }

    @Test
    public void test() {
        FindKthBitinNthBinaryString demo = new FindKthBitinNthBinaryString();
        assertEquals(res, demo.findKthBit(n, k));
    }
}