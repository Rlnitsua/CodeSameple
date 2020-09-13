package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BoatstoSavePeopleTest {
    private final int[] people;
    private final int limit;
    private final int res;

    public BoatstoSavePeopleTest(int[] people, int limit, int res) {
        this.people = people;
        this.limit = limit;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2}, 3, 1},
                {new int[]{3, 2, 2, 1}, 3, 3},
                {new int[]{3, 5, 3, 4}, 5, 4},
        });
    }

    @Test
    public void test() {
        BoatstoSavePeople demo = new BoatstoSavePeople();
        assertEquals(res, demo.numRescueBoats(people, limit));
    }
}