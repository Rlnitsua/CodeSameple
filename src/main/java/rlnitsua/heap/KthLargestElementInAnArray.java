package rlnitsua.heap;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        Heap heap = new Heap(nums.length);
        for (int num : nums) {
            heap.insert(num);
        }
        for (int i = 0; i < k - 1; i++) {
            heap.deleteMax();
        }
        return heap.getMax();
    }

    private static class Heap {
        private final int[] arr;
        private int last = -1;

        public Heap(int heapSize) {
            arr = new int[heapSize];
        }

        public void insert(int val) {
            arr[++last] = val;
            shiftUP(last);
        }

        public int getMax() {
            return arr[0];
        }

        public void deleteMax() {
           arr[0] = arr[last--];
           shiftDown(0);
        }

        private void shiftUP(int index) {
            if (index == 0) {
                return;
            }

            int parent = (index - 1) / 2;
            if (arr[index] > arr[parent]) {
                swap(index, parent);
                shiftUP(parent);
            }
        }

        private void shiftDown(int index) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (right <= last) {
                if (arr[index] < Math.max(arr[left], arr[right])) {
                    if (arr[left] >= arr[right]) {
                        swap(index, left);
                        shiftDown(left);
                    } else {
                        swap(index, right);
                        shiftDown(right);
                    }
                }
            } else if (left == last && arr[index] < arr[left]) {
                swap(index, left);
                shiftDown(left);
            }
        }

        private void swap(int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
