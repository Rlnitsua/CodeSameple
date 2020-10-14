package lizbyu.array;

import lizbyu.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    private static final String TAG = "PascalsTriangle";

    public List<List<Integer>> generate(int numRows) {
        Integer[][] nums = new Integer[numRows][numRows];

        for (int i = 0; i < numRows; i++) {
            nums[i][0] = 1;
        }
        for (int i = 0; i < numRows; i++) {
            nums[i][i] = 1;
        }

        if (numRows > 2) {
            for (int i = 2; i < numRows; i++) {
                for (int j = 1; j < i; j++) {
                    nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
                }
            }
        }

        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> numList = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                numList.add(nums[i][j]);
            }
            triangle.add(numList);
        }

        return triangle;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new PascalsTriangle().generate(5));
    }
}
