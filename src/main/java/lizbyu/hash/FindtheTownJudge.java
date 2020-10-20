package lizbyu.hash;

public class FindtheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];
        for (int[] pair : trust) {
            count[pair[0]]--;
            count[pair[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
