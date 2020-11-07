package rlnitsua.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class JumpFloorTest {
    private final int target;
    private final int res;

    public JumpFloorTest(int target, int res) {
        this.target = target;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {4, 5},
        });
    }

    @Test
    public void test() {
        JumpFloor demo = new JumpFloor();
        assertEquals(res, demo.jumpFloor(target));
    }
}