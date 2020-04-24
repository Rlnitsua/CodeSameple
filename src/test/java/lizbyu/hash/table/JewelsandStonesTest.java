package lizbyu.hash.table;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class JewelsandStonesTest {
    private String J;
    private String S;
    private int num;

    public JewelsandStonesTest(String j, String s, int num) {
        J = j;
        S = s;
        this.num = num;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> preprareData() {
        return Arrays.asList(new Object[][]{
                {"aA", "aAAbbbb", 3},
                {"z", "ZZ", 0},
        });
    }

    @Test
    public void numJewelsInStones() {
        JewelsandStones demo = new JewelsandStones();
        assertEquals(num, demo.numJewelsInStones(J, S));
    }
}