package rlnitsua.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddtoArrayFormofInteger {
    public List<Integer> addToArrayForm(int[] a, int k) {
        int[] b = calculateArray(k);
        List<Integer> res = new ArrayList<>();
        int aIndex = a.length - 1;
        int bIndex = b.length - 1;
        int carry = 0;

        while (aIndex >= 0 || bIndex >= 0) {
            int sum = (aIndex >= 0 ? a[aIndex] : 0) +
                    (bIndex >= 0 ? b[bIndex] : 0) + carry;
            int num = sum % 10;
            carry = sum / 10;
            res.add(num);
            aIndex--;
            bIndex--;
        }

        if (carry != 0) {
            res.add(carry);
        }

        Collections.reverse(res);
        return res;
    }

    private int[] calculateArray(int k) {
        List<Integer> b = new ArrayList<>();

        while (k > 0) {
            b.add(k % 10);
            k /= 10;
        }

        Collections.reverse(b);
        return b.stream().mapToInt(Integer::valueOf).toArray();
    }
}
