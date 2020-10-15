package lizbyu.tree;

import lizbyu.utils.node.TreeNode;

import java.util.Arrays;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }

        int rootVal = postorder[postorder.length - 1];
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, rootIndex);
        root.left = buildTree(leftInorder, leftPostorder);

        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1);
        root.right = buildTree(rightInorder, rightPostorder);

        return root;
    }
}
