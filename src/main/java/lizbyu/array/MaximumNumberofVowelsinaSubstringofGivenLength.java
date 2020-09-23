package lizbyu.array;

public class MaximumNumberofVowelsinaSubstringofGivenLength {
    public int maxVowels(String s, int k) {
        if (k >= s.length()) {
            return getVowelCount(s, 0, s.length() - 1);
        }

        int max = Integer.MIN_VALUE;
        int last = getVowelCount(s, 0, k - 1);
        for (int i = 1; i <= s.length() - k; i++) {
            int current = last - (isVowel(s.charAt(i - 1)) ? 1 : 0)
                    + (isVowel(s.charAt(i + k - 1)) ? 1 : 0);
            max = Math.max(max, last);
            max = Math.max(max, current);
            last = current;
        }

        return max;
    }

    private int getVowelCount(String s, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
