package rlnitsua.contest;

public class MergeTriplets {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int aMax = 0;
        int bMax = 0;
        int cMax = 0;

        for (int[] triplet : triplets) {
            if (triplet[0] == target[0]
                && triplet[1] == target[1]
                && triplet[2] == target[2]) {
                return true;
            }

            if (triplet[0] <= target[0]
                && triplet[1] <= target[1]
                && triplet[2] <= target[2]) {
                aMax = Math.max(aMax, triplet[0]);
                bMax = Math.max(bMax, triplet[1]);
                cMax = Math.max(cMax, triplet[2]);
            }
        }

        return aMax == target[0]
                && bMax == target[1]
                && cMax == target[2];
    }
}
