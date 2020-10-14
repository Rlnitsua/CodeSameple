package lizbyu.string;

import lizbyu.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class ValidWordAbbreviation {
    private static final String TAG = "ValidWordAbbreviation";

    public boolean validWordAbbreviation0(String word, String abbr) {
        StringBuffer sb = new StringBuffer();
        int index = 0;
        for (int i = 0; i < abbr.length(); ) {
            if (isNumber(abbr.charAt(i))) {
                for (int j = i; j < abbr.length() && isNumber(abbr.charAt(j)); j++) {
                    sb.append(abbr.charAt(j));
                    i++;
                }
                if (index == word.length() - Integer.valueOf(new String(sb))
                        && i == abbr.length()) {
                    return true;
                }
                index += Integer.valueOf(new String(sb));
                sb = new StringBuffer();
            } else {
                if (word.charAt(index) != abbr.charAt(i)) {
                    return false;
                } else {
                    if (index == word.length() - 1 &&
                            i == abbr.length() - 1) {
                        return true;
                    }
                    index++;
                    i++;
                }
            }

            if (index >= word.length()) {
                return false;
            }
        }

        if (index != word.length()) {
            return false;
        }
        return true;
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        int index = 0;
        List<String> list = getList(abbr);

        for (String str : list) {
            if (str.length() == 1) {
                if (isNumber(str.charAt(0))) {
                    index++;
                } else {
                    if (word.charAt(index) == str.charAt(0)) {
                        index++;
                    } else {
                        return false;
                    }
                }
            } else {
                index += Integer.valueOf(str);
            }

            if (index > word.length()) {
                return false;
            }
        }

        return true;
    }

    private boolean isNumber(char ch) {
        return (int) ch >= 48 && (int) ch <= 57;
    }

    private List<String> getList(String abbr) {
        List<String> list = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < abbr.length(); ) {
            if (!isNumber(abbr.charAt(i))) {
                list.add(String.valueOf(abbr.charAt(i)));
                i++;
            } else {
                for (int j = i; j < abbr.length() && isNumber(abbr.charAt(j)); j++) {
                    sb.append(abbr.charAt(j));
                    i++;
                }
                list.add(new String(sb));
                sb = new StringBuffer();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, new ValidWordAbbreviation().validWordAbbreviation("internationalization", "i12iz4n"));
        LogUtils.d(TAG, new ValidWordAbbreviation().validWordAbbreviation("apple", "a2e"));
        LogUtils.d(TAG, new ValidWordAbbreviation().validWordAbbreviation("internationalization", "i5a11o1"));
        LogUtils.d(TAG, new ValidWordAbbreviation().validWordAbbreviation("hi", "1"));
        LogUtils.d(TAG, new ValidWordAbbreviation().validWordAbbreviation("abbreviation", "a10n"));

    }
}
