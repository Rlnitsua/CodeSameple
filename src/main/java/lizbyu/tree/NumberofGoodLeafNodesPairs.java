package lizbyu.tree;

import lizbyu.utils.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NumberofGoodLeafNodesPairs {
    public int countPairs(TreeNode root, int distance) {
        preHandle(root);
        List<String> list = new ArrayList<>();
        calculateList(root, list, "");
        int res = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (compareString(list.get(i), list.get(j)) <= distance) {
                    res++;
                }
            }
        }
        return res;
    }

    int val = 0;

    private void preHandle(TreeNode root) {
        if (root == null) {
            return;
        }
        root.val = ++val;
        preHandle(root.left);
        preHandle(root.right);
    }

    private void calculateList(TreeNode root, List<String> list, String s) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(s);
        }
        if (root.left != null) {
            calculateList(root.left, list, s + root.val + root.left.val + "-");
        }
        if (root.right != null) {
            calculateList(root.right, list, s + root.val + root.right.val + "-");
        }
    }

    private int compareString(String p, String q) {
        String[] pSplit = p.split("-");
        String[] qSplit = q.split("-");
        int time = 0;
        for (int i = 0; i < Math.min(pSplit.length, qSplit.length); i++) {
            if (pSplit[i].equals(qSplit[i])) {
                time++;
            } else {
                break;
            }
        }
        return pSplit.length + qSplit.length - (2 * time);
    }
}
