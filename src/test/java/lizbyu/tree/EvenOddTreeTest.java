package lizbyu.tree;

import lizbyu.utils.node.TreeNode;
import lizbyu.utils.node.TreeNodes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class EvenOddTreeTest {
    private final TreeNode root;
    private final boolean res;

    public EvenOddTreeTest(TreeNode root, boolean res) {
        this.root = root;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TreeNodes.create(Arrays.asList(1,10,4,3,null,7,9,12,8,6,null,null,2)), true},
                {TreeNodes.create(Arrays.asList(5,4,2,3,3,7)), false},
                {TreeNodes.create(Arrays.asList(5,9,1,3,5,7)), false},
                {TreeNodes.create(Collections.singletonList(1)), true},
                {TreeNodes.create(Arrays.asList(11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17)), true},
        });
    }

    @Test
    public void test() {
        EvenOddTree demo = new EvenOddTree();
        assertEquals(res, demo.isEvenOddTree(root));
    }
}