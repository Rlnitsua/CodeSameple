package lizbyu.array;

public class MinimumOperationstoMakeArrayEqual {
    public int minOperations(int n) {
        int res = 0;

        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                res += n - (2 * i + 1);
            }
        } else {
            for (int i = 0; i < (n - 1) / 2; i++) {
                res += n - (2 * i + 1);
            }
        }

        return res;
    }
}
