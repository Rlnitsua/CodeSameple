package rlnitsua.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class VerifyinganAlienDictionaryTest {
    private final String[] words;
    private final String order;
    private final boolean res;

    public VerifyinganAlienDictionaryTest(String[] words, String order, boolean res) {
        this.words = words;
        this.order = order;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz", true},
                {new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz", false},
                {new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz", false},
        });
    }

    @Test
    public void test() {
        VerifyinganAlienDictionary demo = new VerifyinganAlienDictionary();
        assertEquals(res, demo.isAlienSorted(words, order));
    }
}