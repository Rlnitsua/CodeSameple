package lizbyu.contest;

import lizbyu.utils.log.LogUtils;

public class DayoftheYear {
    private static final String TAG = "DayoftheYear";

    public int dayOfYear(String date) {
        String[] dateArr = date.split("-");
        int year = Integer.valueOf(dateArr[0]);
        int month = Integer.valueOf(dateArr[1]);
        int day = Integer.valueOf(dateArr[2]);

        int res = 0;
        for (int i = 1; i <= month; i++) {
            if (i == month) {
                res += day;
                break;
            }

            int maxDay = 0;
            if (i == 2) {
                if (year % 400 == 0) {
                    maxDay = 29;
                } else if (year % 100 == 0) {
                    maxDay = 28;
                } else if (year % 4 == 0) {
                    maxDay = 29;
                } else {
                    maxDay = 28;
                }
            } else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                maxDay = 31;
            } else {
                maxDay = 30;
            }
            res += maxDay;
        }
        return res;
    }

    public static void main(String[] args) {
        DayoftheYear d = new DayoftheYear();
//		LogUtils.d(TAG, d.dayOfYear("2019-01-09"));
//		LogUtils.d(TAG, d.dayOfYear("2019-02-10"));
//		LogUtils.d(TAG, d.dayOfYear("2003-03-01"));
//		LogUtils.d(TAG, d.dayOfYear("2004-03-01"));
        LogUtils.d(TAG, d.dayOfYear("1900-03-25"));
    }
}
