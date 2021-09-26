package rlnitsua.contest;

import org.junit.Test;

public class DetectSquaresTest {

    @Test
    public void test() {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});

        System.out.println(detectSquares.count(new int[]{11, 10}));
        System.out.println(detectSquares.count(new int[]{14, 8}));
        detectSquares.add(new int[]{11, 2});
        System.out.println(detectSquares.count(new int[]{11, 10}));
    }

    @Test
    public void test0() {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{0, 0});
        detectSquares.add(new int[]{0, 3});
        detectSquares.add(new int[]{3, 0});

        System.out.println(detectSquares.count(new int[]{3, 3}));
        detectSquares.add(new int[]{3, 3});
        System.out.println(detectSquares.count(new int[]{3, 3}));
    }
}