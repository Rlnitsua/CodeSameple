package rlnitsua.design;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DesignBrowserHistoryTest {
    public static final String LEETCODE = "leetcode.com";
    public static final String GOOGLE = "google.com";
    public static final String FACEBOOK = "facebook.com";
    public static final String YOU2BE = "youtube.com";
    public static final String LINKEDIN = "linkedin.com";

    @Test
    public void test() {
        DesignBrowserHistory demo = new DesignBrowserHistory(LEETCODE);
        demo.visit(GOOGLE);
        demo.visit(FACEBOOK);
        demo.visit(YOU2BE);
        assertEquals(FACEBOOK, demo.back(1));
        assertEquals(GOOGLE, demo.back(1));
        assertEquals(FACEBOOK, demo.forward(1));
        demo.visit(LINKEDIN);
        assertEquals(LINKEDIN, demo.forward(2));
        assertEquals(GOOGLE, demo.back(2));
        assertEquals(LEETCODE, demo.back(7));
    }
}