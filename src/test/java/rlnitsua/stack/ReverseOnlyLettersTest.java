package rlnitsua.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ReverseOnlyLettersTest {
    private final String s;
    private final String res;

    public ReverseOnlyLettersTest(String s, String res) {
        this.s = s;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"ab-cd", "dc-ba"},
                {"a-bC-dEf-ghIj", "j-Ih-gfE-dCba"},
                {"Test1ng-Leet=code-Q!", "Qedo1ct-eeLg=ntse-T!"},
        });
    }

    @Test
    public void test() {
        ReverseOnlyLetters demo = new ReverseOnlyLetters();
        assertEquals(res, demo.reverseOnlyLetters(s));
    }
}