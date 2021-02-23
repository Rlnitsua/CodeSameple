package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GoalParserInterpretationTest {
    private String command;
    private String res;

    public GoalParserInterpretationTest(String command, String res) {
        this.command = command;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"G()(al)", "Goal"},
                {"G()()()()(al)", "Gooooal"},
                {"(al)G(al)()()G", "alGalooG"},
        });
    }

    @Test
    public void test() {
        GoalParserInterpretation demo = new GoalParserInterpretation();
        assertEquals(res, demo.interpret(command));
    }
}