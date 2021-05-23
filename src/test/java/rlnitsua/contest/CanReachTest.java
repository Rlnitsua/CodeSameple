package rlnitsua.contest;

import com.sun.javafx.collections.FloatArraySyncer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CanReachTest {
    private final String s;
    private final int minJump;
    private final int maxJump;
    private final boolean res;

    public CanReachTest(String s, int minJump, int maxJump, boolean res) {
        this.s = s;
        this.minJump = minJump;
        this.maxJump = maxJump;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"011010", 2, 3, true},
                {"01101110", 2, 3, false},
                {"01", 1, 1, false},
        });
    }

    @Test
    public void test() {
        CanReach demo = new CanReach();
        assertEquals(res, demo.canReach(s, minJump, maxJump));
    }
}