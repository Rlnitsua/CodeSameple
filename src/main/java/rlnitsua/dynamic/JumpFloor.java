package rlnitsua.dynamic;

public class JumpFloor {
    public int jumpFloor(int target) {
        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }

        int pre = 1;
        int curr = 2;
        target -= 2;

        while (target != 0) {
            int temp = curr;
            curr += pre;
            pre = temp;
            target--;
        }

        return curr;
    }
}
