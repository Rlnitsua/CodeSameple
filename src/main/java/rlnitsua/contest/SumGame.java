package rlnitsua.contest;

public class SumGame {
    public boolean sumGame(String num) {
        int leftSum = 0;
        int rightSum = 0;
        int leftCount = 0;
        int rightCount = 0;

        for (int i = 0; i < num.length(); i++) {
            int curr = num.charAt(i) == '?' ?
                    0 : Integer.parseInt(num.charAt(i) + "");

            if (i <= (num.length() / 2) - 1) {
                if (num.charAt(i) == '?') {
                    leftCount++;
                } else {
                    leftSum += curr;
                }
            } else {
                if (num.charAt(i) == '?') {
                    rightCount++;
                } else {
                    rightSum += curr;
                }
            }
        }

        if (leftCount == rightCount) {
            return leftSum != rightSum;
        }

        if (leftCount > rightCount && leftSum < rightSum) {
            return (leftCount - rightCount) % 2 != 0
                    || (leftCount - rightCount) / 2 * 9 != (rightSum - leftSum);
        } else if (rightCount > leftCount && rightSum < leftSum) {
            return (rightCount - leftCount) % 2 != 0
                    || (rightCount - leftCount) / 2 * 9 != (leftSum - rightSum);
        }

        return true;
    }
}
