package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FindCommonCharactersTest {
    private final String[] a;
    private final List<String> res;

    public FindCommonCharactersTest(String[] a, List<String> res) {
        this.a = a;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"bella","label","roller"}, Arrays.asList("e","l","l")},
                {new String[]{"cool","lock","cook"}, Arrays.asList("c","o")},
        });
    }

    @Test
    public void test() {
        FindCommonCharacters demo = new FindCommonCharacters();
        assertEquals(res, demo.commonChars(a));
    }
}