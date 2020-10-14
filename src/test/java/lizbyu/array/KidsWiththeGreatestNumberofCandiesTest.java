package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class KidsWiththeGreatestNumberofCandiesTest {
    private int[] candies;
    private int extracCandies;
    private List<Boolean> res;

    public KidsWiththeGreatestNumberofCandiesTest(int[] candies, int extracCandies, List<Boolean> res) {
        this.candies = candies;
        this.extracCandies = extracCandies;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 3, 5, 1, 3}, 3, Arrays.asList(true, true, true, false, true)},
                {new int[]{4, 2, 1, 1, 2}, 1, Arrays.asList(true, false, false, false, false)},
                {new int[]{12, 1, 12}, 10, Arrays.asList(true, false, true)},
        });
    }

    @Test
    public void test() {
        KidsWiththeGreatestNumberofCandies demo = new KidsWiththeGreatestNumberofCandies();
        assertEquals(res, demo.kidsWithCandies(candies, extracCandies));
    }
}