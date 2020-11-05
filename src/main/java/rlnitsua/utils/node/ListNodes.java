package rlnitsua.utils.node;

public class ListNodes {

    private ListNodes() {}

    public static ListNode create(String str) {
        String[] values = str.replace(" ", "").split(",");

        if (values.length == 0) {
            throw new IllegalArgumentException("list values is error");
        }

        ListNode node = new ListNode(Integer.parseInt(values[0]));
        ListNode nodeTemp = node;

        for (int i = 1; i < values.length; i++) {
            node.next = new ListNode(Integer.parseInt(values[i]));
            node = node.next;
        }

        return nodeTemp;
    }

    public static boolean isSame(ListNode p, ListNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            while (p != null && q != null) {
                if (p.val != q.val) {
                    return false;
                } else {
                    p = p.next;
                    q = q.next;
                }
            }
            return p == null && q == null;
        }
    }
}
