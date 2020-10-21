package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnalyzeUserWebsiteVisitPatternTest {
    private final String[] username;
    private final int[] timeStamp;
    private final String[] website;
    private final List<String> res;

    public AnalyzeUserWebsiteVisitPatternTest(String[] username, int[] timeStamp, String[] website, List<String> res) {
        this.username = username;
        this.timeStamp = timeStamp;
        this.website = website;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"joe","joe","joe","james","james","james","james","mary","mary","mary"},
                        new int[]{1,2,3,4,5,6,7,8,9,10},
                        new String[]{"home","about","career","home","cart","maps","home","home","about","career"},
                        Arrays.asList("home","about","career")},
        });
    }

    @Test
    public void test() {
        AnalyzeUserWebsiteVisitPattern demo = new AnalyzeUserWebsiteVisitPattern();
        assertEquals(res, demo.mostVisitedPattern(username, timeStamp, website));
    }
}