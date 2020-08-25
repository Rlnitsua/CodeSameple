package lizbyu.string;

public class ThousandSeparator {
    public String thousandSeparator(int n) {
        if (String.valueOf(n).length() <= 3) {
            return String.valueOf(n);
        }

        char[] numArr = String.valueOf(n).toCharArray();
        StringBuilder sb = new StringBuilder();
        int time = 0;
        for (int i = numArr.length - 1; i >= 0; i--) {
            time++;
            sb.insert(0, numArr[i]);
            if (time % 3 == 0 && time != numArr.length) {
                sb.insert(0, '.');
            }
        }

        return sb.toString();
    }
}
