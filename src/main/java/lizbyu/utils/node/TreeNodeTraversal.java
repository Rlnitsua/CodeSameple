package lizbyu.utils.node;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeTraversal {
    public interface Handler {
        void handleTreeNode(TreeNode treeNode);
    }

    public void traverseDfs(TreeNode head, Handler handler) {
        if (head == null) {
            return;
        }

        handler.handleTreeNode(head);
        traverseDfs(head.left, handler);
        traverseDfs(head.right, handler);
    }

    public void traverseBfs(TreeNode head, Handler handler) {
        if (head == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        while (queue.size() != 0) {
            TreeNode firstNode = queue.poll();
            handler.handleTreeNode(firstNode);

            if (head.left != null) {
                queue.offer(firstNode.left);
            }

            if (head.right != null) {
                queue.offer(firstNode.right);
            }
        }
    }
}
