package rlnitsua.contest;

public class MemLeak {
    public int[] memLeak(int memory1, int memory2) {
        int[] memArr = new int[]{memory1, memory2};
        int crash = memLeak(memArr, 1);
        return new int[]{crash, memArr[0], memArr[1]};
    }

    private int memLeak(int[] memArr, int target) {
        if (target > Math.max(memArr[0], memArr[1])) {
            return target;
        }

        if (memArr[0] >= memArr[1]) {
            memArr[0] -= target;
        } else {
            memArr[1] -= target;
        }

        return memLeak(memArr, target + 1);
    }
}
