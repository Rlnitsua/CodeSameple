package rlnitsua.list;

import rlnitsua.utils.log.LogUtils;
import rlnitsua.utils.node.ListNode;
import rlnitsua.utils.node.ListNodes;

public class PlusOneLinkedList {
    private static final String TAG = "PlusOneLinkedList";

    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return head;
        }

        if (!dfs(head)) {
            return head;
        } else {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
    }

    private boolean dfs(ListNode head) {
        // index of -1 returns 1, means that index of 1 must add one
        if (head == null) {
            return true;
        }

        boolean carryOver = dfs(head.next);

        if (!carryOver) {
            return false;
        } else {
            int num = head.val + 1;
            head.val = num % 10;

            return num / 10 == 1;
        }
    }

    public static void main(String[] args) {
        PlusOneLinkedList plusOneLinkedList = new PlusOneLinkedList();
        ListNode head = ListNodes.create("1, 2, 3");
        LogUtils.d(TAG, plusOneLinkedList.plusOne(head));
    }
}
