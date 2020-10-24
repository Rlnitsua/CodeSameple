package lizbyu.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CheckIfWordIsValidAfterSubstitutionsTest {
    private final String s;
    private final boolean res;

    public CheckIfWordIsValidAfterSubstitutionsTest(String s, boolean res) {
        this.s = s;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"aabcbc", true},
                {"abcabcababcc", true},
                {"abccba", false},
                {"cababc", false},
        });
    }

    @Test
    public void test() {
        CheckIfWordIsValidAfterSubstitutions demo = new CheckIfWordIsValidAfterSubstitutions();
        assertEquals(res, demo.isValid(s));
    }
}