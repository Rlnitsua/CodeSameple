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
public class AddTwoNumbersIITest {
    private final ListNode l1;
    private final ListNode l2;
    private final ListNode res;

    public AddTwoNumbersIITest(ListNode l1, ListNode l2, ListNode res) {
        this.l1 = l1;
        this.l2 = l2;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {ListNodes.create("7,2,4,3"), ListNodes.create("5,6,4"), ListNodes.create("7,8,0,7")},
                {ListNodes.create("5,5,0"), ListNodes.create("4,5,0"), ListNodes.create("1,0,0,0")},
        });
    }

    @Test
    public void test() {
        AddTwoNumbersII demo = new AddTwoNumbersII();
        assertTrue(ListNodes.isSame(res, demo.addTwoNumbers(l1, l2)));
    }
}