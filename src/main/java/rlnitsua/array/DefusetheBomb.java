package rlnitsua.array;

public class DefusetheBomb {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        for (int i = 0; i < res.length; i++) {
            if (k == 0) {
                return res;
            } else if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    int index = (i + j) % code.length;
                    res[i] += code[index];
                }
            } else {
                for (int j = -1; j >= k; j--) {
                    int index = (i + j + code.length) % code.length;
                    res[i] += code[index];
                }
            }
        }
        return res;
    }
}
