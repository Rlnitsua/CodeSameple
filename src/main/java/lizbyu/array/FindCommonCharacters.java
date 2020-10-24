package lizbyu.array;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        int[][] totalInfo = calculateInfo(A);
        List<String> res = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            int minCount = Integer.MAX_VALUE;
            for (int[] info : totalInfo) {
                if (info[i] == 0) {
                    minCount = 0;
                    break;
                } else {
                    minCount = Math.min(minCount, info[i]);
                }
            }
            for (int n = 0; n < minCount; n++) {
                res.add(String.valueOf((char)(i + 97)));
            }
        }

        return res;
    }

    private int[][] calculateInfo(String[] a) {
        int[][] info = new int[a.length][26];
        for (int i = 0; i < info.length; i++) {
            for (char ch : a[i].toCharArray()) {
                info[i][ch - 97]++;
            }
        }
        return info;
    }
}
