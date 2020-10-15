package lizbyu.tree;

import lizbyu.utils.node.TreeNode;

import java.util.Arrays;

// You may assume that duplicates do not exist in the tree.
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) {
            return null;
        }

        int rootVal = preorder[0];
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                rootIndex = i;
            }
        }

        TreeNode treeNode = new TreeNode(rootVal);

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        treeNode.left = buildTree(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        treeNode.right = buildTree(rightPreorder, rightInorder);

        return treeNode;
    }
}
