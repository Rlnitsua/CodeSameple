package rlnitsua.list;

import rlnitsua.utils.node.ListNode;

public class DeleteMiddleNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
