package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RemoveOccurrencesTest {
    private final String s;
    private final String part;
    private final String res;

    public RemoveOccurrencesTest(String s, String part, String res) {
        this.s = s;
        this.part = part;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"daabcbaabcbc", "abc", "dab"},
                {"axxxxyyyyb", "xy", "ab"},
        });
    }

    @Test
    public void test() {
        RemoveOccurrences demo = new RemoveOccurrences();
        assertEquals(res, demo.removeOccurrences(s, part));
    }
}