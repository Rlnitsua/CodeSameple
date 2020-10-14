package lizbyu.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParsingABooleanExpressionTest {
    private final String expression;
    private final boolean res;

    public ParsingABooleanExpressionTest(String expression, boolean res) {
        this.expression = expression;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"!(f)", true},
                {"|(f,t)", true},
                {"&(t,f)", false},
                {"|(&(t,f,t),!(t))", false},
        });
    }

    @Test
    public void test() {
        ParsingABooleanExpression demo = new ParsingABooleanExpression();
        assertEquals(res, demo.parseBoolExpr(expression));
    }
}