package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RotateTheBoxTest {
    private final char[][] box;
    private final char[][] res;

    public RotateTheBoxTest(char[][] box, char[][] res) {
        this.box = box;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new char[][]{new char[]{'#', '.', '#'}},
                        new char[][]{new char[]{'.'}, new char[]{'#'}, new char[]{'#'}}},
                {new char[][]{new char[]{'#', '.', '*', '.'}, new char[]{'#', '#', '*', '.'}},
                        new char[][]{new char[]{'#', '.'}, new char[]{'#', '#'}, new char[]{'*', '*'}, new char[]{'.', '.'}}},
                {new char[][]{new char[]{'#','#','*','.','*','.'}, new char[]{'#','#','#','*','.','.'}, new char[]{'#','#','#','.','#','.'}},
                        new char[][]{new char[]{'.','#','#'}, new char[]{'.','#','#'},
                                    new char[]{'#','#','*'}, new char[]{'#','*','.'},
                                    new char[]{'#','.','*'}, new char[]{'#','.','.'}}},
        });
    }

    @Test
    public void test() {
        RotateTheBox demo = new RotateTheBox();
        assertArrayEquals(res, demo.rotateTheBox(box));
    }
}