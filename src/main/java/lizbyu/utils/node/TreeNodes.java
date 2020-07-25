package lizbyu.utils.node;

import java.util.Arrays;
import java.util.List;

public class TreeNodes {
    private TreeNodes(){}

    public static TreeNode create(List<Integer> valueList){
        return createRootNode(valueList, 0);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private static TreeNode createRootNode(List<Integer> valueSequence, int index) {
        if (index >= valueSequence.size() || valueSequence.get(index) == null) {
            return null;
        }

        TreeNode node = new TreeNode(valueSequence.get(index));
        node.left = createRootNode(valueSequence, 2 * index + 1);
        node.right = createRootNode(valueSequence, 2 * index + 2);
        return node;
    }
}
