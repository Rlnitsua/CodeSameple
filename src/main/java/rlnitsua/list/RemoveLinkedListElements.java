package rlnitsua.list;

import rlnitsua.utils.log.LogUtils;
import rlnitsua.utils.node.ListNode;
import rlnitsua.utils.node.ListNodes;

public class RemoveLinkedListElements {
    private static final String TAG = "RemoveLinkedListElements";

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        LogUtils.d(TAG, new RemoveLinkedListElements().removeElements(head, 1));

        ListNode create = ListNodes.create("1, 2, 6, 5, 6");
        LogUtils.d(TAG, new RemoveLinkedListElements().removeElements(create, 6));
    }
}
