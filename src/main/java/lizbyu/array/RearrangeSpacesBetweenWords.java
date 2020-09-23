package lizbyu.array;

public class RearrangeSpacesBetweenWords {
    public String reorderSpaces(String text) {
        String[] arr = calculateArr(text);
        int spaceNum = 0;
        for (char ch : text.toCharArray()) {
            if (ch == ' ') {
                spaceNum++;
            }
        }
        if (spaceNum == 0) {
            return text;
        }

        StringBuilder sb = new StringBuilder();
        if (arr.length != 1) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
                if (i != arr.length - 1) {
                    for (int j = 0; j < spaceNum / (arr.length - 1); j++) {
                        sb.append(' ');
                    }
                } else {
                    int time = spaceNum / (arr.length - 1);
                    int used = time * (arr.length - 1);
                    for (int j = 0; j < spaceNum - used; j++) {
                        sb.append(' ');
                    }
                }
            }
        } else {
            sb.append(arr[0]);
            for (int i = 0; i < spaceNum; i++) {
                sb.append(' ');
            }
        }


        return sb.toString();
    }

    private String[] calculateArr(String text) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        boolean isSpace = false;

        while (index < text.length()) {
            if (isSpace) {
                if (text.charAt(index) == ' ') {
                    index++;
                    continue;
                }
            }

            isSpace = text.charAt(index) == ' ';
            sb.append(text.charAt(index));
            index++;
        }

        return sb.toString().trim().split(" ");
    }
}
