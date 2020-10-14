package lizbyu.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SingleRowKeyboardTest {
    private String keyboard;
    private String word;
    private int res;

    public SingleRowKeyboardTest(String keyboard, String word, int res) {
        this.keyboard = keyboard;
        this.word = word;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"abcdefghijklmnopqrstuvwxyz", "cba", 4},
                {"pqrstuvwxyzabcdefghijklmno", "leetcode", 73},
        });
    }

    @Test
    public void test() {
        SingleRowKeyboard demo = new SingleRowKeyboard();
        assertEquals(res, demo.calculateTime(keyboard, word));
    }
}