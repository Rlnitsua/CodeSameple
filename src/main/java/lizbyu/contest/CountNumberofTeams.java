package lizbyu.contest;

import java.util.HashMap;
import java.util.Map;

public class CountNumberofTeams {
    public int numTeams(int[] rating) {
        int num = 0;

        Map<Integer, int[]> data = calculateData(rating);

        for (int i = 0; i < rating.length - 2; i++) {
            for (int j = i + 1; j < rating.length - 1; j++) {
                if (rating[i] < rating[j]) {
                    num += data.get(rating[j])[0];
                } else if (rating[i] > rating[j]) {
                    num += data.get(rating[j])[1];
                }
            }
        }

        return num;
    }

    private Map<Integer, int[]> calculateData(int[] rating) {
        Map<Integer, int[]> data = new HashMap<>();

        for (int j = 1; j < rating.length - 1; j++) {
            int[] time = new int[2];
            for (int k = j + 1; k < rating.length; k++) {
                if (rating[j] < rating[k]) {
                    time[0]++;
                } else if (rating[j] > rating[k]) {
                    time[1]++;
                }
            }
            data.put(rating[j], time);
        }

        return data;
    }
}
