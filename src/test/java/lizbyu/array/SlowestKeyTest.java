package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SlowestKeyTest {
    private final int[] releaseTimes;
    private final String keyPressed;
    private final char res;

    public SlowestKeyTest(int[] releaseTimes, String keyPressed, char res) {
        this.releaseTimes = releaseTimes;
        this.keyPressed = keyPressed;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{9,29,49,50}, "cbcd", 'c'},
                {new int[]{12,23,36,46,62}, "spuda", 'a'},
        });
    }

    @Test
    public void test() {
        SlowestKey demo = new SlowestKey();
        assertEquals(res, demo.slowestKey(releaseTimes, keyPressed));
    }
}