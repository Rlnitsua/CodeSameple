package rlnitsua.array;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;

        for (int[] account : accounts) {
            int wealth = 0;
            for (int i = 0; i < accounts[0].length; i++) {
                wealth += account[i];
            }
            maxWealth = Math.max(maxWealth, wealth);
        }

        return maxWealth;
    }
}
