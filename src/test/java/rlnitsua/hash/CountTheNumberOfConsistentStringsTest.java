package rlnitsua.hash;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CountTheNumberOfConsistentStringsTest {
    private final String allowed;
    private final String[] words;
    private final int res;

    public CountTheNumberOfConsistentStringsTest(String allowed, String[] words, int res) {
        this.allowed = allowed;
        this.words = words;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"ab", new String[]{"ad","bd","aaab","baa","badab"}, 2},
                {"abc", new String[]{"a","b","c","ab","ac","bc","abc"}, 7},
                {"cad", new String[]{"cc","acd","b","ba","bac","bad","ac","d"}, 4},
        });
    }

    @Test
    public void test() {
        CountTheNumberOfConsistentStrings demo = new CountTheNumberOfConsistentStrings();
        assertEquals(res, demo.countConsistentStrings(allowed, words));
    }
}