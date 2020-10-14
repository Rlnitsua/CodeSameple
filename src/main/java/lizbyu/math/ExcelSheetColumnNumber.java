package lizbyu.math;

import lizbyu.utils.log.LogUtils;

public class ExcelSheetColumnNumber {
    private static final String TAG = "ExcelSheetColumnNumber";

    public int titleToNumber(String s) {
        int sum = 0;
        int scale = 26;
        char[] numberArray = s.toCharArray();

        for (int index = 0; index < numberArray.length; index++) {
            sum += ((int) numberArray[index] - 64)
                    * Math.pow(scale, (numberArray.length - 1 - index));
        }

        return sum;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, (int) 'A' - 64);
        LogUtils.d(TAG, (int) 'B' - 64);
        LogUtils.d(TAG, (int) 'Z' - 64);
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, "AB : " + new ExcelSheetColumnNumber().titleToNumber("AB"));
    }
}
