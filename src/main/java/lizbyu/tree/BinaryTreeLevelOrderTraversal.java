package lizbyu.tree;

import lizbyu.utils.log.LogUtils;
import lizbyu.utils.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    private static final String TAG = "BinaryTreeLevelOrderTraversal";

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<List<Integer>>();
        insertLevelList(levelList, root, 0);
        return levelList;
    }

    private void insertLevelList(List<List<Integer>> levelList, TreeNode root,
                                 int deep) {
        if (root != null) {
            List<Integer> integerList;
            if (deep >= levelList.size()) {
                integerList = new ArrayList<Integer>();
                integerList.add(root.val);
                levelList.add(integerList);
            } else {
                levelList.get(deep).add(root.val);
            }

            insertLevelList(levelList, root.left, deep + 1);
            insertLevelList(levelList, root.right, deep + 1);
        }
    }

    public static void main(String[] args) {
/*		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);

		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;*/

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new BinaryTreeLevelOrderTraversal().levelOrder(n1));
    }

    public static class BinaryTreeTilt {
        public int findTilt(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return calculateTilt(root) + findTilt(root.left) + findTilt(root.right);
        }

        private int calculateTilt(TreeNode root) {
            return Math.abs(calculateSum(root.left) - calculateSum(root.right));
        }

        private int calculateSum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int sum = root.val;
            sum += calculateSum(root.left);
            sum += calculateSum(root.right);
            return sum;
        }
    }
}
