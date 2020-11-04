package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RearrangeSpacesBetweenWordsTest {
    private final String text;
    private final String res;

    public RearrangeSpacesBetweenWordsTest(String text, String res) {
        this.text = text;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"  this   is  a sentence ", "this   is   a   sentence"},
                {" practice   makes   perfect", "practice   makes   perfect "},
                {"hello   world", "hello   world"},
                {"  walks  udp package   into  bar a", "walks  udp  package  into  bar  a "},
                {"a", "a"},
                {" hello", "hello "},
        });
    }

    @Test
    public void test() {
        RearrangeSpacesBetweenWords demo = new RearrangeSpacesBetweenWords();
        assertEquals(res, demo.reorderSpaces(text));
    }
}