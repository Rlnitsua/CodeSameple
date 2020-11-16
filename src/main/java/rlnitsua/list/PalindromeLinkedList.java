package rlnitsua.list;

import rlnitsua.utils.node.ListNode;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode left = head;
        ListNode right = head;

        while (right.next != null && right.next.next != null) {
            left = left.next;
            right = right.next.next;
        }

        right = left.next;
        left.next = null;
        ListNode temp;
        while (right != null) {
            temp = right.next;
            right.next = left;
            left = right;
            right = temp;
        }

        right = left;
        left = head;

        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}
