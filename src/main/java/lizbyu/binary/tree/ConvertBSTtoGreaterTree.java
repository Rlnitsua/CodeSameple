package lizbyu.binary.tree;

import lizbyu.utils.log.LogUtils;
import lizbyu.utils.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertBSTtoGreaterTree {
    private static final String TAG = "ConvertBSTtoGreaterTree";

    public TreeNode convertBST(TreeNode root) {
        List<Integer> numList = new ArrayList<>();
        getInorderList(root, numList);
        handleRoot(root, numList);
        return root;
    }

    private void getInorderList(TreeNode root, List<Integer> numList) {
        if (root == null) {
            return;
        }
        getInorderList(root.left, numList);
        numList.add(root.val);
        getInorderList(root.right, numList);
    }

    private void handleRoot(TreeNode root, List<Integer> numList) {
        if (root == null) {
            return;
        }
        handleRoot(root.left, numList);
        //handle action
        root.val = getVal(numList, root.val);
        handleRoot(root.right, numList);
    }

    private int getVal(List<Integer> numList, int val) {
        int index = numList.indexOf(val);
        int sum = 0;
        for (int i = index; i < numList.size(); i++) {
            sum += numList.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "start");
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(-4);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        ConvertBSTtoGreaterTree convertBSTtoGreaterTree = new ConvertBSTtoGreaterTree();
        LogUtils.d(TAG, convertBSTtoGreaterTree.convertBST(node1));
    }
}
