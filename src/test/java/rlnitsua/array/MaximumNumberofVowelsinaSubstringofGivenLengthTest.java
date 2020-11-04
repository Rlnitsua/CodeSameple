package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MaximumNumberofVowelsinaSubstringofGivenLengthTest {
    private final String s;
    private final int k;
    private final int res;

    public MaximumNumberofVowelsinaSubstringofGivenLengthTest(String s, int k, int res) {
        this.s = s;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"abciiidef", 3, 3},
                {"aeiou", 2, 2},
                {"leetcode", 3, 2},
                {"rhythms", 4, 0},
                {"tryhard", 4, 1},
        });
    }

    @Test
    public void test() {
        MaximumNumberofVowelsinaSubstringofGivenLength demo = new MaximumNumberofVowelsinaSubstringofGivenLength();
        assertEquals(res, demo.maxVowels(s, k));
    }
}