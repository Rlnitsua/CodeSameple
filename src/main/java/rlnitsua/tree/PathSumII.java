package rlnitsua.tree;

import rlnitsua.utils.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> nodeList = new ArrayList<>();
        recursTree(root, sum, nodeList, paths);
        return paths;
    }

    private void recursTree(TreeNode node, int remainVal, List<Integer> nodeList, List<List<Integer>> paths) {
        if (node == null) {
            return;
        }

        nodeList.add(node.val);

        if (node.val == remainVal && node.left == null && node.right == null) {
            paths.add(new ArrayList<>(nodeList));
        } else {
            recursTree(node.left, remainVal - node.val, nodeList, paths);
            recursTree(node.right, remainVal - node.val, nodeList, paths);
        }

        nodeList.remove(nodeList.size() - 1);
    }
}
