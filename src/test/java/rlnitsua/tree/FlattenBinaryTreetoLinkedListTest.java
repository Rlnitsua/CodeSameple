package rlnitsua.tree;

import rlnitsua.utils.log.LogUtils;
import rlnitsua.utils.node.TreeNode;
import rlnitsua.utils.node.TreeNodes;
import org.junit.Test;

import java.util.Arrays;

public class FlattenBinaryTreetoLinkedListTest {
    private static final String TAG = "FlattenBinaryTreetoLinkedListTest";

    @Test
    public void test() {
        FlattenBinaryTreetoLinkedList demo = new FlattenBinaryTreetoLinkedList();
        TreeNode root = TreeNodes.create(Arrays.asList(1, 2, 5, 3, 4, null, 6));
        demo.flatten(root);
        LogUtils.d(TAG, root);
    }
}