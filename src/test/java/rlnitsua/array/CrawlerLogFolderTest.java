package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CrawlerLogFolderTest {
    private final String[] logs;
    private final int res;

    public CrawlerLogFolderTest(String[] logs, int res) {
        this.logs = logs;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"d1/", "d2/", "../", "d21/", "./"}, 2},
                {new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}, 3},
                {new String[]{"d1/", "../", "../", "../"}, 0},
        });
    }

    @Test
    public void test() {
        CrawlerLogFolder demo = new CrawlerLogFolder();
        assertEquals(res, demo.minOperations(logs));
    }
}