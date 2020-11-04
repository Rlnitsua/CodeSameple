package rlnitsua.contest;


public class NumberofStepsReduceaNumberinX {

    public int numSteps(String s) {
        int time = 0;

        while (s.length() != 1) {
            char[] chArr = s.toCharArray();
            if (chArr[chArr.length - 1] == '1') {
                int index = -1;
                for (int j = chArr.length - 1; j >= 0; j--) {
                    if (chArr[j] != '1') {
                        index = j;
                        break;
                    }
                }

                for (int j = index + 1; j < chArr.length; j++) {
                    chArr[j] = '0';
                }

                if (index != -1) {
                    chArr[index] = '1';
                    s = new String(chArr);
                } else {
                    s = "1" + new String(chArr);
                }
                time++;
            } else {
                s = s.substring(0, s.length() - 1);
                time++;
            }
        }

        return time;
    }

    // time limited
    /*public int numSteps(String s) {
        int num = calculateNum(s);
        int time = 0;

        while(num != 1) {
            if (num % 2 != 0) {
                num++;
                time++;
            }
            num /= 2;
            time++;
        }

        return time;
    }

    private int calculateNum(String s) {
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            num += Integer.parseInt(String.valueOf(s.charAt(i))) * Math.pow(2, s.length() - i - 1);
        }

        return num;
    }*/
}
