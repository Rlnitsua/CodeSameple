package lizbyu.tree;

import lizbyu.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.List;

/*
 * Input: 
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation: 
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.
*/

public class KillProcess {
    private static final String TAG = "KillProcess";

    class TreeNode {
        private int val;
        private List<TreeNode> nodeList;

        public TreeNode(int val) {
            this.val = val;
            nodeList = new ArrayList<>();
        }

        public List<TreeNode> getNodeList() {
            return nodeList;
        }

        public int getVal() {
            return val;
        }
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(new TreeNode(0));
        for (Integer pidVal : pid) {
            nodeList.add(new TreeNode(pidVal));
        }

        for (int i = 0; i < pid.size(); i++) {
            getNodeByVal(nodeList, ppid.get(i)).getNodeList().add(getNodeByVal(nodeList, pid.get(i)));
        }

        return getChildNumByVal(getNodeByVal(nodeList, kill));
    }

    private TreeNode getNodeByVal(List<TreeNode> nodeList, int val) {
        for (TreeNode node : nodeList) {
            if (node.val == val) {
                return node;
            }
        }
        return null;
    }

    private List<Integer> getChildNumByVal(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }

        res.add(node.val);
        for (TreeNode nodeItem : node.nodeList) {
            res.addAll(getChildNumByVal(nodeItem));
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> pid = new ArrayList<>();
        pid.add(1);
        pid.add(3);
        pid.add(10);
        pid.add(5);
        List<Integer> ppid = new ArrayList<>();
        ppid.add(3);
        ppid.add(0);
        ppid.add(5);
        ppid.add(3);
        KillProcess killProcess = new KillProcess();
        LogUtils.d(TAG, killProcess.killProcess(pid, ppid, 5));
    }
}
