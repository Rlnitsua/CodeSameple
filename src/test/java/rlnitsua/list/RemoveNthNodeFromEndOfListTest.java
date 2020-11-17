package rlnitsua.list;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import rlnitsua.utils.node.ListNode;
import rlnitsua.utils.node.ListNodes;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RemoveNthNodeFromEndOfListTest {
    private final ListNode head;
    private final int n;
    private final ListNode res;

    public RemoveNthNodeFromEndOfListTest(ListNode head, int n, ListNode res) {
        this.head = head;
        this.n = n;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {ListNodes.create("1,2,3,4,5"), 2, ListNodes.create("1,2,3,5")},
        });
    }

    @Test
    public void test() {
        RemoveNthNodeFromEndOfList demo = new RemoveNthNodeFromEndOfList();
        assertTrue(ListNodes.isSame(res, demo.removeNthFromEnd(head, n)));
    }
}