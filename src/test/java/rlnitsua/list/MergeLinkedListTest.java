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
public class MergeLinkedListTest {
    private final ListNode l1;
    private final ListNode l2;
    private final ListNode mergeList;

    public MergeLinkedListTest(ListNode l1, ListNode l2, ListNode mergeList) {
        this.l1 = l1;
        this.l2 = l2;
        this.mergeList = mergeList;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {ListNodes.create("1,2"), ListNodes.create("1"), ListNodes.create("1,1,2")},
                {null, ListNodes.create("1"), ListNodes.create("1")},
                {ListNodes.create("1,2"), null, ListNodes.create("1,2")},
                {ListNodes.create("1,2,2,3,3,4,5"), ListNodes.create("1,2,3,4,5"), ListNodes.create("1,1,2,2,2,3,3,3,4,4,5,5")},
        });
    }

    @Test
    public void test() {
        MergeLinkedList demo = new MergeLinkedList();
        assertTrue(ListNodes.isSame(demo.mergeTwoLists(l1, l2), mergeList));
        assertTrue(ListNodes.isSame(demo.mergeTwoListsTraversal(l1, l2), mergeList));
    }
}