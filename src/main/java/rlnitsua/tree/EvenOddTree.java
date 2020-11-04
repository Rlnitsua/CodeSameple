package rlnitsua.tree;

import rlnitsua.utils.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        List<List<Integer>> info = new ArrayList<>();
        traversal(root, info, 0);
        return isEvenOdd(info);
    }

    private boolean isEvenOdd(List<List<Integer>> info) {
        if (info.size() == 1) {
            return info.get(0).get(0) % 2 != 0;
        }

        for (int i = 0; i < info.size(); i++) {
            List<Integer> list = info.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (i % 2 == 0) {
                    if (list.get(j) % 2 == 0) {
                        return false;
                    }
                    if (j == list.size() - 1) {
                        break;
                    }
                    if (list.get(j + 1) <= list.get(j)) {
                        return false;
                    }
                } else {
                    if (list.get(j) % 2 != 0) {
                        return false;
                    }
                    if (j == list.size() - 1) {
                        break;
                    }
                    if (list.get(j + 1) >= list.get(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void traversal(TreeNode root, List<List<Integer>> info, int level) {
        if (root == null) {
            return;
        }

        if (info.size() < level + 1) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            info.add(list);
        } else {
            info.get(level).add(root.val);
        }
        traversal(root.left, info, level + 1);
        traversal(root.right, info, level + 1);
    }
}
