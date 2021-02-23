package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RemoveVowelsFromAStringTest {
    private String s;
    private String res;

    public RemoveVowelsFromAStringTest(String s, String res) {
        this.s = s;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                        {"leetcodeisacommunityforcoders", "ltcdscmmntyfrcdrs"},
                        {"aeiou", ""},
                }
        );
    }

    @Test
    public void test() {
        RemoveVowelsFromAString demo = new RemoveVowelsFromAString();
        assertEquals(res, demo.removeVowels(s));
    }
}