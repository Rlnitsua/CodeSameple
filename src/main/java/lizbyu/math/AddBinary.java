package lizbyu.math;

import lizbyu.utils.log.LogUtils;

import java.util.Stack;

public class AddBinary {
    private static final String TAG = "AddBinary";

    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return "";
        }

        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        Stack<Integer> stack3 = new Stack<Integer>();

        for (char ch : a.toCharArray()) {
            stack1.push(Integer.parseInt(ch + ""));
        }
        for (char ch : b.toCharArray()) {
            stack2.push(Integer.parseInt(ch + ""));
        }

        boolean isCarryOver = false;
        while (stack1.size() != 0 || stack2.size() != 0) {
            int num1 = 0;
            int num2 = 0;
            if (stack1.size() != 0) {
                num1 = stack1.pop();
            }
            if (stack2.size() != 0) {
                num2 = stack2.pop();
            }

            int numx = 0;
            if (num1 + num2 + (isCarryOver ? 1 : 0) >= 2) {
                numx = (num1 + num2 + (isCarryOver ? 1 : 0)) % 2;
                isCarryOver = true;
            } else {
                numx = num1 + num2 + (isCarryOver ? 1 : 0);
                isCarryOver = false;
            }
            stack3.push(numx);
        }

        if (isCarryOver) {
            stack3.push(1);
        }

        StringBuffer sb = new StringBuffer();
        while (stack3.size() != 0) {
            sb.append(stack3.pop());
        }

        return new String(sb);
    }

    public static void main(String[] args) {
//		LogUtils.d(TAG, new AddBinary().addBinary("0", "0"));
//		LogUtils.d(TAG, new AddBinary().addBinary("1", "11"));
        LogUtils.d(TAG, new AddBinary().addBinary("1011101010", "1011010"));
    }
}
