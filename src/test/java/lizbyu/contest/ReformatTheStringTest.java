package lizbyu.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ReformatTheStringTest {
    private String str;
    private String res;

    public ReformatTheStringTest(String str, String res) {
        this.str = str;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
//                {"a0b1c2", "0a1b2c"},
                {"leetcode", ""},
                {"1229857369", ""},
                {"covid2019", "c2o0v1i9d"}
        });
    }

    @Test
    public void reformat() {
        ReformatTheString demo = new ReformatTheString();
        assertEquals(res, demo.reformat(str));
    }
}