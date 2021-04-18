package rlnitsua.design;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SimplifyPathTest {
    private final String originPath;
    private final String res;

    public SimplifyPathTest(String originPath, String res) {
        this.originPath = originPath;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"/home/", "/home"},
                {"/../", "/"},
                {"/home//foo/", "/home/foo"},
                {"/a/./b/../../c/", "/c"},
        });
    }

    @Test
    public void test() {
        SimplifyPath demo = new SimplifyPath();
        assertEquals(res, demo.simplifyPath(originPath));
    }
}