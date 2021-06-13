package rlnitsua.contest;

public class MakeEqual {
    public boolean makeEqual(String[] words) {
        int[] table = new int[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                table[ch - 'a']++;
            }
        }

        for (int num : table) {
            if (num % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
