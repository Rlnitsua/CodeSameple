package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BrickWallTest {
    private final List<List<Integer>> wall;
    private final int res;

    public BrickWallTest(List<List<Integer>> wall, int res) {
        this.wall = wall;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(Arrays.asList(1,2,2,1),
                        Arrays.asList(3,1,2),
                        Arrays.asList(1,3,2),
                        Arrays.asList(2,4),
                        Arrays.asList(3,1,2),
                        Arrays.asList(1,3,1,1)), 2},
                {Arrays.asList(Collections.singletonList(1),
                        Collections.singletonList(1),
                        Collections.singletonList(1)), 3},
        });
    }

    @Test
    public void test() {
        BrickWall demo = new BrickWall();
        assertEquals(res, demo.leastBricks(wall));
    }
}