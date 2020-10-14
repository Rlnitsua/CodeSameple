package lizbyu.dfs;

import lizbyu.utils.log.LogUtils;

import java.util.Stack;

public class TernaryExpressionParser {
    private static final String TAG = "TernaryExpressionParser";

    private Stack<Character> stack;

    public TernaryExpressionParser() {
        stack = new Stack<>();
    }

    public String parseTernary(String expression) {
        char[] chArr = expression.toCharArray();
        for (int i = chArr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peek() == '?') {
                judge(chArr[i]);
            } else {
                stack.push(chArr[i]);
            }
        }
        return String.valueOf(stack.pop());
    }

    private void judge(char operator) {
        stack.pop();
        char param1 = stack.pop();
        stack.pop();
        char param2 = stack.pop();
        stack.push((operator == 'T') ? param1 : param2);
    }

    public static void main(String[] args) {
        TernaryExpressionParser ternaryExpressionParser = new TernaryExpressionParser();
//		LogUtils.d(TAG, ternaryExpressionParser.parseTernary("T?2:3"));
//		LogUtils.d(TAG, ternaryExpressionParser.parseTernary("F?1:T?4:5"));
//		LogUtils.d(TAG, ternaryExpressionParser.parseTernary("T?T?F:5:3"));
        LogUtils.d(TAG, ternaryExpressionParser.parseTernary("T?T:F?T?1:2:F?3:4"));
    }
}
