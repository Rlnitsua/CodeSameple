package rlnitsua.contest;

public class MaximumNumber {
    public String maximumNumber(String num, int[] change) {
        StringBuilder sb = new StringBuilder();
        int index = -1;
        boolean isChanged = false;

        for (int i = 0; i < num.length(); i++) {
            int currNum = Integer.parseInt(num.charAt(i) + "");
            if (change[currNum] > currNum) {
                isChanged = true;
                sb.append(change[currNum]);
            } else if (change[currNum] == currNum) {
                sb.append(currNum);
            }else {
                if (isChanged) {
                    index = i;
                    break;
                } else {
                    sb.append(currNum);
                }
            }
        }
        if (index != -1) {
            sb.append(num.substring(index));
        }
        return sb.toString();
    }
}
