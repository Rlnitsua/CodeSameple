package lizbyu.tree;

import java.util.ArrayList;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        int level = 0;

        while (true) {
            if (label >= Math.pow(2, level) && label <= Math.pow(2, level + 1) - 1) {
                break;
            } else {
                level++;
            }
        }

        addPath(label, res, level);
        return res;
    }

    private void addPath(int label, List<Integer> res, int level) {
        res.add(0, label);

        if (level == 0) {
            return;
        }
        if (level %2 != 0) {
            int other = (int) (Math.pow(2, level) + Math.pow(2, level + 1) - 1 - label);
            addPath(getParent(other), res, level - 1);
        } else {
            int otherParent = (int) (Math.pow(2, level - 1) + Math.pow(2, level) - 1 - getParent(label));
            addPath(otherParent, res, level - 1);
        }
    }

    private int getParent(int label) {
        if (label %2 == 0) {
            return label / 2;
        } else {
            return (label - 1) / 2;
        }
    }
}
