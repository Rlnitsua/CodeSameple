package lizbyu.array;

import java.util.*;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> info = new HashMap<>();
        List<Integer> otherArr = new ArrayList<>();

        handleArr(arr1, arr2, info, otherArr);
        List<Integer> existArr = getExistArr(arr2, info);

        List<Integer> res = new ArrayList<>();
        res.addAll(existArr);
        res.addAll(otherArr);

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void handleArr(int[] arr1, int[] arr2, Map<Integer, Integer> info, List<Integer> otherArr) {
        for (int num : arr1) {
            if (contains(arr2, num)) {
                info.put(num, info.getOrDefault(num, 0) + 1);
            } else {
                otherArr.add(num);
            }
        }
        Collections.sort(otherArr);
    }

    private boolean contains(int[] arr, int key) {
        for (int num : arr) {
            if (num == key) {
                return true;
            }
        }
        return false;
    }

    private List<Integer> getExistArr(int[] arr2, Map<Integer, Integer> info) {
        List<Integer> existArr = new ArrayList<>();
        for (int num2 : arr2) {
            for (int i = 0; i < info.get(num2); i++) {
                existArr.add(num2);
            }
        }
        return existArr;
    }
}
