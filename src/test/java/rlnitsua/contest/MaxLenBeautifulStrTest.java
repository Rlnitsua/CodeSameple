package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaxLenBeautifulStrTest {
    private final String word;
    private final int res;

    public MaxLenBeautifulStrTest(String word, int res) {
        this.word = word;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"aeiaaioaaaaeiiiiouuuooaauuaeiu", 13},
                {"aeeeiiiioooauuuaeiou", 5},
                {"a", 0},
        });
    }

    @Test
    public void test() {
        MaxLenBeautifulStr demo = new MaxLenBeautifulStr();
        assertEquals(res, demo.longestBeautifulSubstring(word));
    }
}