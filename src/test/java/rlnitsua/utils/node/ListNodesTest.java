package rlnitsua.utils.node;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ListNodesTest {
    private final ListNode p;
    private final ListNode q;
    private final boolean res;

    public ListNodesTest(ListNode p, ListNode q, boolean res) {
        this.p = p;
        this.q = q;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, null, true},
                {null, ListNodes.create("1,2,3"), false},
                {ListNodes.create("1,2,3"), null, false},
                {ListNodes.create("1,2,3"), ListNodes.create("1,2,3"), true},
                {ListNodes.create("1,2,3"), ListNodes.create("1,2,3,4"), false},
                {ListNodes.create("1,2,3,4"), ListNodes.create("1,2,3"), false},
                {ListNodes.create("1,2,4,4"), ListNodes.create("1,2,3,4"), false},
        });
    }

    @Test
    public void test() {
        assertSame(ListNodes.isSame(p, q), res);
    }
}