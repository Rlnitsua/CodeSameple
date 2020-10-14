package lizbyu.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ShuffleStringTest {
    private String s;
    private int[] indices;
    private String res;

    public ShuffleStringTest(String s, int[] indices, String res) {
        this.s = s;
        this.indices = indices;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}, "leetcode"},
                {"abc", new int[]{0, 1, 2}, "abc"},
                {"aiohn", new int[]{3, 1, 4, 2, 0}, "nihao"},
                {"aaiougrt", new int[]{4, 0, 2, 6, 7, 3, 1, 5}, "arigatou"},
                {"art", new int[]{1, 0, 2}, "rat"},
        });
    }

    @Test
    public void test() {
        ShuffleString demo = new ShuffleString();
        assertEquals(res, demo.restoreString(s, indices));
    }
}