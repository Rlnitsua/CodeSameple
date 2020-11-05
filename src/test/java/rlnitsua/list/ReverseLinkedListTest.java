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
public class ReverseLinkedListTest {
    private final ListNode head;
    private final ListNode res;

    public ReverseLinkedListTest(ListNode head, ListNode res) {
        this.head = head;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {ListNodes.create("1,2,3"), ListNodes.create("3,2,1")},
        });
    }

    @Test
    public void test() {
        ReverseLinkedList demo = new ReverseLinkedList();
        assertTrue(ListNodes.isSame(res, demo.reverseList(head)));
    }
}