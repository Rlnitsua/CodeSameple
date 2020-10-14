package lizbyu.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CountNumberofTeamsTest {
    private int[] rating;
    private int res;

    public CountNumberofTeamsTest(int[] rating, int res) {
        this.rating = rating;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 5, 3, 4, 1}, 3},
                {new int[]{2, 1, 3}, 0},
                {new int[]{1, 2, 3, 4}, 4}
        });
    }

    @Test
    public void numTeams() {
        CountNumberofTeams demo = new CountNumberofTeams();
        assertEquals(demo.numTeams(rating), res);
    }
}