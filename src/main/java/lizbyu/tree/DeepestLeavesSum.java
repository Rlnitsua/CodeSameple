package lizbyu.tree;

import lizbyu.utils.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelTraversal(root, list, 0);
        int res = 0;
        for (int num : list.get(list.size() - 1)) {
            res += num;
        }
        return res;
    }

    private void levelTraversal(TreeNode root, List<List<Integer>> list, int level) {
        if (root == null) {
            return;
        }

        if (list.size() <= level) {
            List<Integer> l = new ArrayList<>();
            list.add(l);
        }

        list.get(level).add(root.val);

        levelTraversal(root.left, list, level + 1);
        levelTraversal(root.right, list, level + 1);
    }
}
