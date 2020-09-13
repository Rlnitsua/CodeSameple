package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CountUnhappyFriendsTest {
    private final int n;
    private final int[][] preferences;
    private final int[][] pairs;
    private final int res;

    public CountUnhappyFriendsTest(int n, int[][] preferences, int[][] pairs, int res) {
        this.n = n;
        this.preferences = preferences;
        this.pairs = pairs;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4, new int[][]{new int[]{1,2,3}, new int[]{3,2,0}, new int[]{3,1,0}, new int[]{1,2,0}},
                        new int[][]{new int[]{0,1}, new int[]{2,3}}, 2},
                {2, new int[][]{new int[]{1}, new int[]{0}}, new int[][]{new int[]{1,0}}, 0},
                {4, new int[][]{new int[]{1,3,2}, new int[]{2,3,0}, new int[]{1,3,0}, new int[]{0,2,1}},
                        new int[][]{new int[]{1,3}, new int[]{0,2}}, 4},
        });
    }

    @Test
    public void test() {
        CountUnhappyFriends demo = new CountUnhappyFriends();
        assertEquals(res, demo.unhappyFriends(n, preferences, pairs));
    }
}