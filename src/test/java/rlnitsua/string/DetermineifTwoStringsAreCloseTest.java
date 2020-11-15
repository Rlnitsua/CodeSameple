package rlnitsua.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class DetermineifTwoStringsAreCloseTest {
    private final String word1;
    private final String word2;
    private final boolean res;

    public DetermineifTwoStringsAreCloseTest(String word1, String word2, boolean res) {
        this.word1 = word1;
        this.word2 = word2;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"abc", "bca", true},
                {"a", "aa", false},
                {"cabbba", "abbccc", true},
                {"cabbba", "aabbss", false},
                {"aabbcc", "aabbss", false},
        });
    }

    @Test
    public void test() {
        DetermineifTwoStringsAreClose demo = new DetermineifTwoStringsAreClose();
        assertEquals(res, demo.closeStrings(word1, word2));
    }
}