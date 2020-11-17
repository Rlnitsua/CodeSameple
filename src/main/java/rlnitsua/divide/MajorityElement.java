package rlnitsua.divide;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int cand = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                cand = num;
            }
            count += (cand == num) ? 1 : -1;
        }

        return cand;
    }
}
