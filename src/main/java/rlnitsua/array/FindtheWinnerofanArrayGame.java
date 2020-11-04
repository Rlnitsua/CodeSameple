package rlnitsua.array;

public class FindtheWinnerofanArrayGame {
    public int getWinner(int[] arr, int k) {
        if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        }

        int res = arr[0];
        if (k >= arr.length) {
            for (int i = 1; i < arr.length; i++) {
                res = Math.max(res, arr[i]);
            }
            return res;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                int time = 0;
                for (int j = i + 1; j < i + 1 + k; j++) {
                    if (arr[i] > arr[j]) {
                        time++;
                    } else {
                        break;
                    }
                }
                if (time == k) {
                    return arr[0];
                }
            } else {
                int max = arr[0];
                for (int j = 1; j < arr.length; j++) {
                    if (arr[j] > max) {
                        int time = 0;
                        max = arr[j];
                        for (int n = j + 1; n < arr.length; n++) {
                            if (arr[j] > arr[n]) {
                                time++;
                            } else {
                                break;
                            }
                        }
                        if (time >= k - 1) {
                            return arr[j];
                        } else if (time == arr.length - 1 - j) {
                            return arr[j];
                        }
                    }
                }
            }
        }
        return 0;
    }
}
