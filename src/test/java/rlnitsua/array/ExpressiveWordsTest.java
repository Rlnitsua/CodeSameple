package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ExpressiveWordsTest {
    private final String S;
    private final String[] words;
    private final int res;

    public ExpressiveWordsTest(String s, String[] words, int res) {
        S = s;
        this.words = words;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"heeellooo", new String[]{"hello", "hi", "helo"}, 1}
        });
    }

    @Test
    public void test() {
        ExpressiveWords demo = new ExpressiveWords();
        assertEquals(res, demo.expressiveWords(S, words));
    }
}