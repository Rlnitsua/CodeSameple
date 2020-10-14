package lizbyu.hash;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ShortestCompletingWordTest {
    private final String licensePlate;
    private final String[] words;
    private final String res;

    public ShortestCompletingWordTest(String licensePlate, String[] words, String res) {
        this.licensePlate = licensePlate;
        this.words = words;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}, "steps"},
                {"1s3 456", new String[]{"looks", "pest", "stew", "show"}, "pest"},
                {"Ah71752", new String[]{"suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent", "writer", "old"}, "husband"},
                {"OgEu755", new String[]{"enough", "these", "play", "wide", "wonder", "box", "arrive", "money", "tax", "thus"}, "enough"},
                {"iMSlpe4", new String[]{"claim", "consumer", "student", "camera", "public", "never", "wonder", "simple", "thought", "use"}, "simple"},
        });
    }

    @Test
    public void test() {
        ShortestCompletingWord demo = new ShortestCompletingWord();
        assertEquals(res, demo.shortestCompletingWord(licensePlate, words));
    }
}