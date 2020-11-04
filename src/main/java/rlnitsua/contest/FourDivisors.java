package rlnitsua.contest;


import java.util.HashMap;
import java.util.Map;

public class FourDivisors {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        Map<Integer, int[]> cache = new HashMap<>();

        for (Integer num : nums) {
            int[] divisors;
            if (cache.containsKey(num)) {
                divisors = cache.get(num);
            } else {
                if (preJdugeFourDivisors(cache, num)) {
                    divisors = getDivisors(num);
                } else {
                    continue;
                }
            }

            if (divisors != null) {
                cache.put(num, divisors);
                for (Integer divisor : divisors) {
                    res += divisor;
                }
            }
        }
        return res;
    }

    private boolean preJdugeFourDivisors(Map<Integer, int[]> cache, Integer num) {
        for (Integer cacheItem : cache.keySet()) {
            if (num > cacheItem && num % cacheItem == 0) {
                return false;
            }
        }
        return true;
    }

    private int[] getDivisors(Integer num) {
        int[] res = new int[4];
        int count = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                if (count == 3 && num != i) {
                    return null;
                }

                if (count == 4) {
                    return null;
                }
                res[count] = i;
                count++;
            }
        }

        if (count != 4) {
            return null;
        }

        return res;
    }
}
