package rlnitsua.array;

import rlnitsua.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextClosestTime {
    private static final String TAG = "NextClosestTime";

    public String nextClosestTime(String time) {
        char[] charArr = time.toCharArray();
        List<Integer> numList = getNumList(charArr);
        int changeIndex = -1;

        for (int i = charArr.length - 1; i >= 0; i--) {
            if (i == 2) {
                continue;
            }
            if (getNextNum(charArr, i, numList) != -1) {
                changeIndex = i;
                charArr[i] = getCharFromNum(getNextNum(charArr, i, numList));
                break;
            }
        }

        if (changeIndex != charArr.length - 1) {
            for (int j = changeIndex + 1; j < charArr.length; j++) {
                if (j == 2) {
                    continue;
                }
                charArr[j] = getCharFromNum(numList.get(0));
            }
        }

        if (changeIndex != -1) {
            return new String(charArr);
        } else {
            return getSmallTime(charArr, numList);
        }
    }

    private List<Integer> getNumList(char[] charArr) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < charArr.length; i++) {
            if (i == 2) {
                continue;
            }
            numList.add(Integer.valueOf(String.valueOf(charArr[i])));
        }
        Collections.sort(numList);
        return numList;
    }

    private int getNextNum(char[] chArr, int index, List<Integer> numList) {
        int currentNum = Integer.valueOf(String.valueOf(chArr[index]));
        int nextIndex = getNextIndex(currentNum, numList);

        if (index == 4) {
            if (nextIndex == -1) {
                return -1;
            }
        } else if (index == 3) {
            if (nextIndex == -1 || numList.get(nextIndex) > 5) {
                return -1;
            }
        } else if (index == 1) {
            if (nextIndex == -1 || (chArr[0] == '2' && numList.get(nextIndex) > 4)) {
                return -1;
            }
        } else if (index == 0) {
            if (nextIndex == -1 || numList.get(nextIndex) > 2) {
                return -1;
            }
        }
        return numList.get(nextIndex);
    }

    private int getNextIndex(int val, List<Integer> numList) {
        int index = -1;
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) == val) {
                index = i;
            }
        }
        return index == (numList.size() - 1) ? -1 : (index + 1);
    }

    private char getCharFromNum(int val) {
        return String.valueOf(val).toCharArray()[0];
    }

    private String getSmallTime(char[] charArr, List<Integer> numList) {
        for (int i = 0; i < charArr.length; i++) {
            if (i == 2) {
                continue;
            }
            charArr[i] = getCharFromNum(numList.get(0));
        }
        return new String(charArr);
    }

    public static void main(String[] args) {
        String time0 = "19:34";
        String time1 = "23:59";
        String time2 = "13:55";
        NextClosestTime next = new NextClosestTime();
        LogUtils.d(TAG, next.nextClosestTime(time0));
        LogUtils.d(TAG, next.nextClosestTime(time1));
        LogUtils.d(TAG, next.nextClosestTime(time2));
    }
}
