package lizbyu.tree;

import lizbyu.utils.log.LogUtils;
import lizbyu.utils.node.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSumIVInputisaBST {
    private static final String TAG = "TwoSumIVInputisaBST";

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> valList = new ArrayList<Integer>();
        getList(root, valList);

        for (int num : valList) {
            List<Integer> valListTemp = new ArrayList<Integer>();
            Collections.copy(valListTemp, valList);
            valListTemp.remove(num);

            if (valListTemp.contains(k - num)) {
                return true;
            }
        }

        return false;
    }

    private void getList(TreeNode root, List<Integer> valList) {
        if (root == null) {
            return;
        }

        valList.add(root.val);
        getList(root.left, valList);
        getList(root.right, valList);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
//		TreeNode node1 = new TreeNode(3);
//		TreeNode node2 = new TreeNode(6);
//		TreeNode node3 = new TreeNode(2);
//		TreeNode node4 = new TreeNode(4);
//		TreeNode node5 = new TreeNode(7);
//		
//		head.left = node1;
//		head.right = node2;
//		node1.left = node3;
//		node1.right = node4;
//		node2.right = node5;

        LogUtils.d(TAG, new TwoSumIVInputisaBST().findTarget(head, 2));
    }
}
