package lizbyu.string;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        } else if (word.length() == 2) {
            if (isLowercase(word.charAt(0)) && !isLowercase(word.charAt(1))) {
                return false;
            }
        }

        if (!isLowercase(word.charAt(0)) && !isLowercase(word.charAt(1))) {
            for (int i = 2; i < word.length(); i++) {
                if (isLowercase(word.charAt(i))) {
                    return false;
                }
            }
        } else if (!isLowercase(word.charAt(0)) && isLowercase(word.charAt(1))) {
            for (int i = 2; i < word.length(); i++) {
                if (!isLowercase(word.charAt(i))) {
                    return false;
                }
            }
        } else if (isLowercase(word.charAt(0))) {
            for (int i = 1; i < word.length(); i++) {
                if (!isLowercase(word.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isLowercase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

}
