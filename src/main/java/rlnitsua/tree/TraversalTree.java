package rlnitsua.tree;

import rlnitsua.utils.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TraversalTree {
    public int[][] threeOrders (TreeNode root) {
        int nodeCount = getCount(root);
        int[][] res = new int[3][nodeCount];

        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        res[0] = list.stream().mapToInt(Integer::intValue).toArray();
        list.clear();

        inOrder(root, list);
        res[1] = list.stream().mapToInt(Integer::intValue).toArray();
        list.clear();

        postOrder(root, list);
        res[2] = list.stream().mapToInt(Integer::intValue).toArray();
        list.clear();

        return res;
    }

    private int getCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getCount(node.left) + getCount(node.right);
    }

    private void preOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    private void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }
}
