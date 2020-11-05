package rlnitsua.list;

import rlnitsua.utils.node.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode root = null;
        ListNode last = null;

        while (head != null) {
            root = new ListNode(head.val);
            root.next = last;
            last = root;
            head = head.next;
        }

        return root;
    }
}
