package rlnitsua.tree;

import rlnitsua.utils.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        List<Integer> list = new ArrayList<>();
        initialList(root, list);
        reValueTree(root, list, 0);
    }

    private void initialList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        initialList(root.left, list);
        initialList(root.right, list);
    }

    private void reValueTree(TreeNode root, List<Integer> list, int index) {
        root.left = null;
        root.val = list.get(index++);

        if (index != list.size()) {
            root.right = new TreeNode();
            reValueTree(root.right, list, index);
        }
    }
}
