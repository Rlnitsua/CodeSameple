package lizbyu.array;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        List<Integer> oneIndexList = new ArrayList<>();
        char[] charArr = s.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '1') {
                oneIndexList.add(i);
            }
        }

        return 0;
    }
}
