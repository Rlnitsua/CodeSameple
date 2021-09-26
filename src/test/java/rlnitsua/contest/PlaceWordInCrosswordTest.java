package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PlaceWordInCrosswordTest {
    private final char[][] board;
    private final String word;
    private final boolean res;

    public PlaceWordInCrosswordTest(char[][] board, String word, boolean res) {
        this.board = board;
        this.word = word;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new char[][]{new char[]{'#', ' ', '#'}, new char[]{' ', ' ', '#'},
                        new char[]{'#', 'c', ' '}, }, "abc", true},
                {new char[][]{new char[]{' ', '#', 'a'}, new char[]{' ', '#', 'c'},
                        new char[]{' ', '#', 'a'}, }, "ac", false},
                {new char[][]{new char[]{'#', ' ', '#'}, new char[]{' ', ' ', '#'},
                        new char[]{'#', ' ', 'c'}, }, "ca", true},
        });
    }

    @Test
    public void test() {
        PlaceWordInCrossword demo = new PlaceWordInCrossword();
        assertEquals(res, demo.placeWordInCrossword(board, word));
    }
}