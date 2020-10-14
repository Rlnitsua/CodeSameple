package lizbyu.greedy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GroupthePeopleGiventheGroupSizeTheyBelongToTest {
    private int[] groupSizes;
    private List<List<Integer>> res;

    public GroupthePeopleGiventheGroupSizeTheyBelongToTest(int[] groupSizes, List<List<Integer>> res) {
        this.groupSizes = groupSizes;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, 3, 3, 3, 3, 1, 3}, Arrays.asList(Arrays.asList(0, 1, 2), Collections.singletonList(5), Arrays.asList(3, 4, 6))},
                {new int[]{2, 1, 3, 3, 3, 2}, Arrays.asList(Collections.singletonList(1), Arrays.asList(2, 3, 4), Arrays.asList(0, 5))},
        });
    }

    @Test
    public void test() {
        GroupthePeopleGiventheGroupSizeTheyBelongTo Demo = new GroupthePeopleGiventheGroupSizeTheyBelongTo();
        assertEquals(res, Demo.groupThePeople(groupSizes));
    }
}