package rlnitsua.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ')') {
                List<Character> list = new ArrayList<>();
                while (true) {
                    Character pop = stack.pop();
                    if (pop == '!') {
                        stack.push(turnAround(list.get(0)));
                        break;
                    } else if (pop == '&') {
                        if (list.contains('f')) {
                            stack.push('f');
                        } else {
                            stack.push('t');
                        }
                        break;
                    } else if (pop == '|') {
                        if (list.contains('t')) {
                            stack.push('t');
                        } else {
                            stack.push('f');
                        }
                        break;
                    } else {
                        list.add(pop);
                    }
                }
            } else if (ch != ',' && ch != '(') {
                stack.push(ch);
            }
        }

        return stack.pop() == 't';
    }

    private char turnAround(char ch) {
        if (ch == 'f') {
            return 't';
        } else {
            return 'f';
        }
    }
}
