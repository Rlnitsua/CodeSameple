package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IsSumEqualTest {
    private final String first;
    private final String second;
    private final String target;
    private final boolean res;

    public IsSumEqualTest(String first, String second, String target, boolean res) {
        this.first = first;
        this.second = second;
        this.target = target;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"acb", "cba", "cdb", true},
                {"aaa", "a", "aab", false},
                {"aaa", "a", "aaaa", true}
        });
    }

    @Test
    public void test() {
        IsSumEqual demo = new IsSumEqual();
        assertEquals(res, demo.isSumEqual(first, second, target));
    }
}