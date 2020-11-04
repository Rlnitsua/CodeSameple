package rlnitsua.tree;

import rlnitsua.utils.log.LogUtils;
import rlnitsua.utils.node.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MostFrequentSubtreeSum {
    private static final String TAG = "MostFrequentSubtreeSum";

    private List<Integer> subTreeSum;

    public int[] findFrequentTreeSum(TreeNode root) {
        subTreeSum = new ArrayList<>();
        dfs(root);

        Map<Integer, Integer> record = getRecord();
        List<Integer> resList = getResList(record);

        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            subTreeSum.add(root.val);
            return root.val;
        }

        int leftValues = dfs(root.left);
        int rightValues = dfs(root.right);
        subTreeSum.add(leftValues + rightValues + root.val);
        return leftValues + rightValues + root.val;
    }

    private Map<Integer, Integer> getRecord() {
        Map<Integer, Integer> record = new HashMap<>();
        for (int sum : subTreeSum) {
            if (record.get(sum) != null) {
                record.put(sum, record.get(sum) + 1);
            } else {
                record.put(sum, 1);
            }
        }
        return record;
    }

    private List<Integer> getResList(Map<Integer, Integer> record) {
        List<Integer> resList = new ArrayList<>();
        int mostFrequentNum = 0;
        for (Entry<Integer, Integer> entry : record.entrySet()) {
            if (mostFrequentNum == 0) {
                mostFrequentNum = entry.getValue();
                resList.add(entry.getKey());
            } else {
                if (entry.getValue() == mostFrequentNum) {
                    resList.add(entry.getKey());
                } else if (entry.getValue() > mostFrequentNum) {
                    resList.clear();
                    mostFrequentNum = entry.getValue();
                    resList.add(entry.getKey());
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        LogUtils.d(TAG, new MostFrequentSubtreeSum().findFrequentTreeSum(node));
    }
}
