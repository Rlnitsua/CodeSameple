package rlnitsua.list;

import rlnitsua.utils.log.LogUtils;
import rlnitsua.utils.node.ListNode;
import rlnitsua.utils.node.ListNodes;

import java.util.Stack;

public class AddTwoNumbersII {
    private static final String TAG = "AddTwoNumbersII";

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = getQueue(l1);
        Stack<Integer> stack2 = getQueue(l2);
        return addTwoStack(stack1, stack2);
    }

    private Stack<Integer> getQueue(ListNode node) {
        Stack<Integer> stack = new Stack<Integer>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        return stack;
    }

    private ListNode addTwoStack(Stack<Integer> stack1, Stack<Integer> stack2) {
        ListNode head = null;
        boolean isOverride = false;
        while (stack1.size() != 0 || stack2.size() != 0) {
            int part1 = (stack1.size() == 0) ? 0 : stack1.pop();
            int part2 = (stack2.size() == 0) ? 0 : stack2.pop();
            ListNode node = new ListNode((part1 + part2 + (isOverride ? 1 : 0)) % 10);
            isOverride = ((part1 + part2 + (isOverride ? 1 : 0)) >= 10) ? true : false;
            node.next = head;
            head = node;
        }

        if (isOverride) {
            ListNode node = new ListNode(1);
            node.next = head;
            head = node;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNodes.create("7,2,4,3");
        ListNode l2 = ListNodes.create("5,6,4");

        AddTwoNumbersII addTwoNumbersII = new AddTwoNumbersII();
        LogUtils.d(TAG, addTwoNumbersII.addTwoNumbers(l1, l2));
    }
}
