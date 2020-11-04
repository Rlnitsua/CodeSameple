package rlnitsua.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> resultList = new ArrayList<String>();

        for (int i = 1; i <= n; i++) {
            String result = calculateResult(i);
            resultList.add(result);
        }
        return resultList;
    }

    private String calculateResult(int i) {
        String result;
        boolean multipleOfThree = (i % 3 == 0);
        boolean multipleOfFive = (i % 5 == 0);

        // most possible appear
        if (!multipleOfThree && !multipleOfFive) {
            result = Integer.toString(i);
        }
        // second possible appear
        else if (multipleOfThree && !multipleOfFive) {
            result = "Fizz";
        }
        // third possible appear
        else if (!multipleOfThree && multipleOfFive) {
            result = "Buzz";
        }
        // last possible appear
        else {
            result = "FizzBuzz";
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(Arrays.toString(new FizzBuzz().fizzBuzz(n).toArray()));
    }
}
