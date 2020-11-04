package rlnitsua.dfs;

import java.util.List;

public class NestedListWeightSum {
//	private static final String TAG = "NestedListWeightSum";

    public int depthSum(List<NestedInteger> nestedList) {
        int depth = 0;
        for (NestedInteger nestedInteger : nestedList) {
            depth += calculateDepth(nestedInteger, 1);
        }
        return depth;
    }

    private int calculateDepth(NestedInteger nestedInteger, int depth) {
        if (nestedInteger.isInteger()) {
            return nestedInteger.getInteger() * depth;
        } else {
            int depthSum = 0;
            depth++;
            for (NestedInteger nestedIntegerItem : nestedInteger.getList()) {
                depthSum += calculateDepth(nestedIntegerItem, depth);
            }
            return depthSum;
        }
    }

    public static void main(String[] args) {
    }
}
