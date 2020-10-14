package lizbyu.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ValidWordSquareTest {
    private List<String> words;
    private boolean res;

    public ValidWordSquareTest(List<String> words, boolean res) {
        this.words = words;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList("abcd", "bnrt", "crmy", "dtye"), true},
                {Arrays.asList("abcd", "bnrt", "crm", "dt"), true},
                {Arrays.asList("ball", "area", "read", "lady"), false},
                {Arrays.asList("abc", "b"), false},
                {Arrays.asList("c", "de"), false},
                {Arrays.asList("c", "de"), false},
                {Arrays.asList("aa", "ad", "ad"), false},
        });
    }

    @Test
    public void test() {
        ValidWordSquare demo = new ValidWordSquare();
        assertEquals(res, demo.validWordSquare(words));
    }
}