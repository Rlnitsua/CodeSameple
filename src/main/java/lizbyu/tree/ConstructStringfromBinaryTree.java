package lizbyu.tree;

import lizbyu.utils.log.LogUtils;
import lizbyu.utils.node.TreeNode;

public class ConstructStringfromBinaryTree {
    private static final String TAG = "ConstructStringfromBinaryTree";

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        String treeStr = createStr(t);
        return deleteEnd(doOmit(treeStr));
    }

    private String createStr(TreeNode t) {
        StringBuffer sb = new StringBuffer();
        if (t == null) {
            return "";
        }
        sb.append(t.val);
        sb.append("(");
        sb.append(createStr(t.left));
        sb.append(")");
        sb.append("(");
        sb.append(createStr(t.right));
        sb.append(")");

        return new String(sb);
    }

    private String doOmit(String treeStr) {
        if (!treeStr.contains("())")) {
            return treeStr;
        }
        return doOmit(treeStr.replace("())", ")"));
    }

    private String deleteEnd(String doOmit) {
        if (!doOmit.endsWith("()")) {
            return doOmit;
        }
        doOmit = doOmit.substring(0, doOmit.length() - 2);
        return deleteEnd(doOmit);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;

        LogUtils.d(TAG, new ConstructStringfromBinaryTree().tree2str(t1));


        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2);
        TreeNode t13 = new TreeNode(3);
        TreeNode t14 = new TreeNode(4);

        t11.left = t12;
        t12.left = t13;
        t12.right = t14;

        LogUtils.d(TAG, new ConstructStringfromBinaryTree().tree2str(t11));
    }
}
