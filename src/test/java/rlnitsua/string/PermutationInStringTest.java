package rlnitsua.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PermutationInStringTest {
    private final String s1;
    private final String s2;
    private final boolean res;

    public PermutationInStringTest(String s1, String s2, boolean res) {
        this.s1 = s1;
        this.s2 = s2;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"ab", "eidbaooo", true},
                {"ab", "eidboaoo", false},
        });
    }

    @Test
    public void test() {
        PermutationInString demo = new PermutationInString();
        assertEquals(res, demo.checkInclusion(s1, s2));
    }
}