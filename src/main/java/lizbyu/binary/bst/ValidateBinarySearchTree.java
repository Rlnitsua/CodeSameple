package lizbyu.binary.bst;

import lizbyu.utils.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> valList = new ArrayList<>();
        inorderTraversal(root, valList);

        for (int i = 0; i < valList.size() - 1; i++) {
            if (valList.get(i) >= valList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorderTraversal(TreeNode root, List<Integer> valList) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, valList);
        valList.add(root.val);
        inorderTraversal(root.right, valList);
    }
}
