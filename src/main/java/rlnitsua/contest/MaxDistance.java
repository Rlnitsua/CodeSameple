package rlnitsua.contest;

public class MaxDistance {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDistance = 0;
        for (int startIndex = 0; startIndex < nums1.length; startIndex++) {
            int lastIndex = lastIndex(startIndex, nums1[startIndex], nums2);

            if (lastIndex == nums2.length - 1) {
                maxDistance = Math.max(maxDistance, lastIndex - startIndex);
                return maxDistance;
            } else {
                maxDistance = Math.max(maxDistance, lastIndex - startIndex);
            }
        }
        return maxDistance;
    }

    private int lastIndex(int startIndex, int target, int[] nums2) {
        int l = startIndex - 1;
        int r = nums2.length;

        while (l != r - 1) {
            int mid = (l + r) / 2;
            if (nums2[mid] >= target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
