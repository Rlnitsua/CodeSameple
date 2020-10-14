package lizbyu.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class QueriesonaPermutationWithKeyTest {
    private int[] queries;
    private int m;
    private int[] res;

    public QueriesonaPermutationWithKeyTest(int[] queries, int m, int[] res) {
        this.queries = queries;
        this.m = m;
        this.res = res;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, 1, 2, 1}, 5, new int[]{2, 1, 2, 1}},
                {new int[]{4, 1, 2, 2}, 4, new int[]{3, 1, 2, 0}},
                {new int[]{7, 5, 5, 8, 3}, 8, new int[]{6, 5, 0, 7, 5}}
        });
    }

    @Test
    public void processQueries() {
        QueriesonaPermutationWithKey demo = new QueriesonaPermutationWithKey();
        assertArrayEquals(demo.processQueries(queries, m), res);
    }
}