package rlnitsua.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ReverseStringInAStringIITest {
    private final char[] s;
    private final char[] res;

    public ReverseStringInAStringIITest(char[] s, char[] res) {
        this.s = s;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'},
                        new char[]{'b', 'l', 'u', 'e', ' ', 'i', 's', ' ', 's', 'k', 'y', ' ', 't', 'h', 'e'}},
        });
    }

    @Test
    public void test() {
        ReverseStringInAStringII demo = new ReverseStringInAStringII();
        demo.reverseWords(s);
        assertArrayEquals(res, s);
    }
}