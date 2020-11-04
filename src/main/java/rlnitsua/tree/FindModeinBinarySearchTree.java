package rlnitsua.tree;

import rlnitsua.utils.node.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FindModeinBinarySearchTree {
    private int max = 0;
    private Map<Integer, Integer> nodeMap;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        nodeMap = new HashMap<Integer, Integer>();
        getNodeMap(root);

        List<Integer> resList = new ArrayList<Integer>();

        for (Entry<Integer, Integer> entry : nodeMap.entrySet()) {
            if (entry.getValue() == max) {
                resList.add(entry.getKey());
            }
        }

        int[] res = new int[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }

        return res;
    }

    private void getNodeMap(TreeNode root) {
        nodeMap.put(root.val, nodeMap.get(root.val) == null ? 0 : nodeMap.get(root.val) + 1);
        max = Math.max(max, nodeMap.get(root.val));
        if (root.left != null) {
            getNodeMap(root.left);
        }
        if (root.right != null) {
            getNodeMap(root.right);
        }
    }
}
