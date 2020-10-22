package lizbyu.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ReverseWordsinaStringIIITest {
    private final String s;
    private final String res;

    public ReverseWordsinaStringIIITest(String s, String res) {
        this.s = s;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"contest", "tsetnoc"},
                {"Let's take LeetCode contest", "s'teL ekat edoCteeL tsetnoc"},
                {"contest ", "tsetnoc "},
        });
    }

    @Test
    public void test() {
        ReverseWordsinaStringIII demo = new ReverseWordsinaStringIII();
        assertEquals(res, demo.reverseWords(s));
    }
}