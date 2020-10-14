package lizbyu.binary.tree;

import lizbyu.utils.node.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();

        int deep = calculateDeep(root);
        String[][] resArr = new String[deep][(1 << deep) - 1];
        initResArr(resArr);

        fill(resArr, root, 0, 0, resArr[0].length);

        copyArrToRes(resArr, res);
        return res;
    }

    private int calculateDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(calculateDeep(root.left), calculateDeep(root.right));
    }

    private void initResArr(String[][] resArr) {
        for (String[] resItem : resArr) {
            Arrays.fill(resItem, "");
        }
    }

    private void fill(String[][] resArr, TreeNode root, int deep, int leftIndex, int rightIndex) {
        if (root == null) {
            return;
        }
        resArr[deep][(leftIndex + rightIndex) / 2] = String.valueOf(root.val);
        fill(resArr, root.left, deep + 1, leftIndex, (leftIndex + rightIndex) / 2);
        fill(resArr, root.right, deep + 1, (leftIndex + rightIndex) / 2, rightIndex);
    }

    private void copyArrToRes(String[][] resArr, List<List<String>> res) {
        for (String[] resItem : resArr) {
            res.add(Arrays.asList(resItem));
        }
    }

}
