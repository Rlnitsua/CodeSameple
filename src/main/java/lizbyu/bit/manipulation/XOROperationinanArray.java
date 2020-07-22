package lizbyu.bit.manipulation;

public class XOROperationinanArray {
    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            int temp = start + 2 * i;
            res ^= temp;
        }
        return res;
    }
}
