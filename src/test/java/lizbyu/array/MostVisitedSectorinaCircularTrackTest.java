package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MostVisitedSectorinaCircularTrackTest {
    private int n;
    private int[] rounds;
    private List<Integer> res;

    public MostVisitedSectorinaCircularTrackTest(int n, int[] rounds, List<Integer> res) {
        this.n = n;
        this.rounds = rounds;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4, new int[]{1, 3, 1, 2}, Arrays.asList(1, 2)},
                {2, new int[]{2,1,2,1,2,1,2,1,2}, Collections.singletonList(2)},
                {7, new int[]{1,3,5,7}, Arrays.asList(1,2,3,4,5,6,7)},
        });
    }

    @Test
    public void test() {
        MostVisitedSectorinaCircularTrack demo = new MostVisitedSectorinaCircularTrack();
        assertEquals(res, demo.mostVisited(n, rounds));
    }
}