package rlnitsua.contest;

public class MaxCompatibilitySum {
    int max = Integer.MIN_VALUE;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean[] isMentorSelect = new boolean[mentors.length];
        int[] studentPair = new int[mentors.length];
        maxCompatibilitySum(students, mentors, isMentorSelect, 0, studentPair);
        return max;
    }

    private void maxCompatibilitySum(int[][] students, int[][] mentors,
                                    boolean[] isMentorSelect, int studentIndex, int[] studentPair) {
        if (studentIndex == students.length) {
            int sum = 0;
            for (int i = 0; i < studentPair.length; i++) {
                sum += calculateScore(students[i], mentors[studentPair[i]]);
            }
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < isMentorSelect.length; i++) {
            if (!isMentorSelect[i]) {
                isMentorSelect[i] = true;
                studentPair[studentIndex] = i;
                maxCompatibilitySum(students, mentors, isMentorSelect, studentIndex + 1, studentPair);
                isMentorSelect[i] = false;
            }
        }
    }

    private int calculateScore(int[] a, int[] b) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {
                count++;
            }
        }
        return count;
    }
}
