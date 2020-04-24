package lizbyu.array;

public class DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        int resSize = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                resSize += nums[i];
            }
        }

        int[] res = new int[resSize];
        int index = 0;
        int freq = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                freq = nums[i];
            } else {
                for (int j = index; j < index + freq; j++) {
                    res[j] = nums[i];
                }
                index += freq;
            }
        }

        return res;
    }
}
