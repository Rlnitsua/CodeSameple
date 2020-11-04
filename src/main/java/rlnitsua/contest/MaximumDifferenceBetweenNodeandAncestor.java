package rlnitsua.contest;

import rlnitsua.utils.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumDifferenceBetweenNodeandAncestor {
    public int maxAncestorDiff(TreeNode root) {
        List<Integer> maxDiff = caculateMaxDiffList(root);
        int res = Integer.MIN_VALUE;
        for (Integer diff : maxDiff) {
            res = diff > res ? diff : res;
        }
        return res;
    }

    private List<Integer> caculateMaxDiffList(TreeNode root) {
        List<Integer> maxDiffList = new ArrayList<>();
        List<List<Integer>> nodeValueList = new ArrayList<>();
        caculateNodeValueList(root, nodeValueList);
        for (List<Integer> nodaValue : nodeValueList) {
            maxDiffList.add(getMaxDiff(nodaValue));
        }
        return maxDiffList;
    }

    private Integer getMaxDiff(List<Integer> nodaValue) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Integer value : nodaValue) {
            max = value > max ? value : max;
            min = value < min ? value : min;
        }
        return max - min;
    }

    private List<List<Integer>> caculateNodeValueList(TreeNode root, List<List<Integer>> nodeValueList) {
        if (root.left == null && root.right == null) {
            return nodeValueList;
        }

        List<Integer> currentValueList = new ArrayList<>();
        currentValueList.add(root.val);
//		caculateNodeValueList(root.left, currentValueList);
//		caculateNodeValueList(root.right, currentValueList);

        nodeValueList.add(currentValueList);
        return nodeValueList;
    }

    public static void main(String[] args) {

    }
}
