package rlnitsua.list;

import rlnitsua.utils.node.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = getStack(l1);
        Deque<Integer> stack2 = getStack(l2);

        ListNode ans = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            ListNode curr = new ListNode(sum % 10);
            curr.next = ans;
            ans = curr;
        }

        return ans;
    }

    private Deque<Integer> getStack(ListNode node) {
        Deque<Integer> stack = new LinkedList<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        return stack;
    }
}
