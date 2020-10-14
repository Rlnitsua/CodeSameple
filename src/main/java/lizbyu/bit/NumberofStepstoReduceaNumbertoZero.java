package lizbyu.bit;

import java.util.ArrayList;
import java.util.List;

public class NumberofStepstoReduceaNumbertoZero {
    public int numberOfSteps(int num) {
        List<Integer> nums = getNumArray(num);

        int index = 0;
        int step = 0;

        while (nums.get(nums.size() - 1) != 0) {
            if (nums.get(index) == 1) {
                nums.set(index, 0);
            } else {
                index++;
            }
            step++;
        }

        return step;
    }

    private List<Integer> getNumArray(int num) {
        List<Integer> list = new ArrayList<>();

        int left = num;
        while (left != 1) {
            int bit = left % 2;
            list.add(bit);
            left /= 2;
        }
        list.add(left);

        return list;
    }


}
