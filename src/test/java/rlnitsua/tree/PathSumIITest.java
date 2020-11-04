package rlnitsua.tree;

import rlnitsua.utils.node.TreeNode;
import rlnitsua.utils.node.TreeNodes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PathSumIITest {
    private TreeNode root;
    private int sum;
    private List<List<Integer>> res;

    public PathSumIITest(TreeNode root, int sum, List<List<Integer>> res) {
        this.root = root;
        this.sum = sum;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TreeNodes.create(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1)),
                        22, Arrays.asList(Arrays.asList(5, 4, 11, 2), Arrays.asList(5, 8, 4, 5))},
        });
    }

    @Test
    public void test() {
        PathSumII demo = new PathSumII();
        assertEquals(res, demo.pathSum(root, sum));
    }
}