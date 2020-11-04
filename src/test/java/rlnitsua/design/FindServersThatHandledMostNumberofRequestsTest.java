package rlnitsua.design;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FindServersThatHandledMostNumberofRequestsTest {
    private final int k;
    private final int[] arrival;
    private final int[] load;
    private final List<Integer> res;

    public FindServersThatHandledMostNumberofRequestsTest(int k, int[] arrival, int[] load, List<Integer> res) {
        this.k = k;
        this.arrival = arrival;
        this.load = load;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3, new int[]{1, 2, 3, 4, 5}, new int[]{5, 2, 3, 3, 3}, Collections.singletonList(1)},
                {3, new int[]{1, 2, 3, 4}, new int[]{1, 2, 1, 2}, Collections.singletonList(0)},
                {3, new int[]{1, 2, 3}, new int[]{10, 12, 11}, Arrays.asList(0, 1, 2)},
                {3, new int[]{1, 2, 3, 4, 8, 9, 10}, new int[]{5, 2, 10, 3, 1, 2, 2}, Collections.singletonList(1)},
                {1, new int[]{1}, new int[]{1}, Collections.singletonList(0)},
        });
    }

    @Test
    public void test() {
        FindServersThatHandledMostNumberofRequestsTLE demo = new FindServersThatHandledMostNumberofRequestsTLE();
        assertEquals(res, demo.busiestServers(k, arrival, load));
    }
}