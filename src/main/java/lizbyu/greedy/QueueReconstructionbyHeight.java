package lizbyu.greedy;

import lizbyu.utils.log.LogUtils;

public class QueueReconstructionbyHeight {
    private static final String TAG = "QueueReconstructionbyHeight";

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return people;
        }

        sortPeopleKLo2Hi(people);
        sortPeopleHHi2Lo(people);

        int[][] res = new int[people.length][people[0].length];
        reconstructPeople(people, res);
        return res;
    }

    private void sortPeopleKLo2Hi(int[][] people) {
        for (int i = 0; i < people.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j][1] > people[j + 1][1]) {
                    swap(people, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    private void sortPeopleHHi2Lo(int[][] people) {
        for (int i = 0; i < people.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j][0] < people[j + 1][0]) {
                    swap(people, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    private void swap(int[][] people, int j, int i) {
        int[] temp = people[j];
        people[j] = people[i];
        people[i] = temp;
    }

    private void reconstructPeople(int[][] people, int[][] res) {
        res[0] = people[0];
        for (int i = 1; i < people.length; i++) {
            insert(res, people[i], people[i][1]);
        }
    }

    private void insert(int[][] res, int[] content, int position) {
        int[][] resTemp = res;
        System.arraycopy(resTemp, position, res, position + 1, res.length - position - 1);
        res[position] = content;
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        LogUtils.d(TAG, new QueueReconstructionbyHeight().reconstructQueue(people));
    }
}
