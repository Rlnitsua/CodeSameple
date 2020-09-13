package lizbyu.array;

public class CountUnhappyFriends {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int res = 0;
        int[] last = getLast(pairs, n);

        for (int i = 0; i < n; i++) {
            for (int obj : preferences[i]) {
                if (obj == last[i]) {
                    break;
                }
                if (checkLike(preferences[obj], i, last[obj])) {
                    res++;
                    break;
                }
            }
        }

        return res;
    }

    private int[] getLast(int[][] pairs, int n) {
        int[] last = new int[n];
        for (int[] pair : pairs) {
            last[pair[0]] = pair[1];
            last[pair[1]] = pair[0];
        }
        return last;
    }

    private boolean checkLike(int[] preferences, int current, int last) {
        for (int like : preferences) {
            if (like == current) {
                return true;
            } else if (like == last) {
                return false;
            }
        }
        return false;
    }
}
