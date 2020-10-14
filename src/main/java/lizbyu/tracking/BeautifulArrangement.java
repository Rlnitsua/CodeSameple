package lizbyu.tracking;

import lizbyu.utils.log.LogUtils;

public class BeautifulArrangement {
    private static final String TAG = "BeautifulArrangement";

    private int count = 0;

    public int countArrangement(int N) {
        doHandle(N, 1, new int[N + 1]);
        return count;
    }

    private void doHandle(int n, int position, int[] used) {
        if (position > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i] == 0 && (i % position == 0 || position % i == 0)) {
                used[i] = 1;
                doHandle(n, position + 1, used);
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, new BeautifulArrangement().countArrangement(4));
        LogUtils.d(TAG, new BeautifulArrangement().countArrangement(5));
        LogUtils.d(TAG, new BeautifulArrangement().countArrangement(6));
    }
}
