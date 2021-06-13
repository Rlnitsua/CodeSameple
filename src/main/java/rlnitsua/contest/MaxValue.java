package rlnitsua.contest;

public class MaxValue {
    public String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder();
        boolean isContain = false;

        if (n.startsWith("-")) {
            sb.append("-");
            for (int i = 1; i < n.length(); i++) {
                int num = Integer.parseInt(n.substring(i, i + 1));
                if (num <= x) {
                    sb.append(num);
                } else {
                    isContain = true;
                    sb.append(x);
                    sb.append(n.substring(i));
                    break;
                }
            }
        } else {
            for (int i = 0; i < n.length(); i++) {
                int num = Integer.parseInt(n.substring(i, i + 1));
                if (num >= x) {
                    sb.append(num);
                } else {
                    isContain = true;
                    sb.append(x);
                    sb.append(n.substring(i));
                    break;
                }
            }
        }

        if (!isContain) {
            sb.append(x);
        }

        return sb.toString();
    }
}
