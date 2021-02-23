package rlnitsua.array;

public class RemoveVowelsFromAString {
    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder(s.length());

        for (char ch : s.toCharArray()) {
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
