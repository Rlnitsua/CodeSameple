package lizbyu.array;

public class MaximumProfitofOperatingaCentennialWheel {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int last = 0;
        int already = 0;
        int minOperation = -1;
        int maxProfit = Integer.MIN_VALUE;
        int index = 0;
        int shiftCount = 0;
        int totalCustomer = 0;

        for (int customer : customers) {
            totalCustomer += customer;
        }

        while (already != totalCustomer) {
            if (index < customers.length) {
                last += customers[index];
            }

            if (last >= 4) {
                already += 4;
                last -= 4;
            } else {
                already += last;
                last = 0;
            }

            shiftCount++;
            int cost = already * boardingCost - shiftCount * runningCost;
            if (cost > 0 && cost > maxProfit) {
                maxProfit = cost;
                minOperation = shiftCount;
            }
            index++;
        }

        return minOperation;
    }
}
