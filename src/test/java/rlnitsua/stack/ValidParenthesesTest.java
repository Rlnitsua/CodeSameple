package rlnitsua.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ValidParenthesesTest {
    private final String s;
    private final boolean isSame;

    public ValidParenthesesTest(String s, boolean isSame) {
        this.s = s;
        this.isSame = isSame;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"[", false},
                {"()[]{()()}", true},
        });
    }

    @Test
    public void test() {
        ValidParentheses demo = new ValidParentheses();
        assertEquals(isSame, demo.isValid(s));
    }
}