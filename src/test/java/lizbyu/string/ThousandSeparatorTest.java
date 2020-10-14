package lizbyu.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ThousandSeparatorTest {
    private final int n;
    private final String res;

    public ThousandSeparatorTest(int n, String res) {
        this.n = n;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {987, "987"},
                {1234, "1.234"},
                {123456789, "123.456.789"},
                {0, "0"},
        });
    }

    @Test
    public void test() {
        ThousandSeparator demo = new ThousandSeparator();
        assertEquals(res, demo.thousandSeparator(n));
    }
}