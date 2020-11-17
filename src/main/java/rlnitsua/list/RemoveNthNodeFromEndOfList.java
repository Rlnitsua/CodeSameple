package rlnitsua.list;

import rlnitsua.utils.node.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }

        // n -= len
        ListNode node = head;
        while (node != null) {
            n--;
            node = node.next;
        }

        if (n == 0) {
            head = head.next;
        } else if (n < 0) {
            node = head;
            while (++n != 0) {
                node = node.next;
            }
            node.next = node.next.next;
        }

        return head;
    }
}
