package rlnitsua.list;

import rlnitsua.utils.node.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode meet;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                meet = slow;
                slow = head;
                while (meet != slow) {
                    meet = meet.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;
    }
}
