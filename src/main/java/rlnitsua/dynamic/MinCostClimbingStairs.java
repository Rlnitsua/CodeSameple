package rlnitsua.dynamic;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return 0;
        }

        int[] costArr = new int[cost.length];
        costArr[0] = cost[0];
        costArr[1] = cost[1];
        for (int i = 2; i < costArr.length; i++) {
            costArr[i] = Math.min(cost[i] + costArr[i - 1], cost[i] + costArr[i - 2]);
        }

        return Math.min(costArr[cost.length - 1], costArr[cost.length - 2]);
    }
}
