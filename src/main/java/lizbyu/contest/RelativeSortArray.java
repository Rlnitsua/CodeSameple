package lizbyu.contest;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import lizbyu.utils.log.LogUtils;

public class RelativeSortArray {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] res = new int[arr1.length];
		int arr2PartialIndex = handleFirstParty(res, arr1, arr2);
		Map<Integer, Integer> arr1OnlyMap = getMap(arr1, arr2);
		int[] arr1SortArr = getArr(arr1OnlyMap);
		
		int resIndex = arr2PartialIndex;
		for (int i = 0; i < arr1SortArr.length; i++) {
			int currentNum = arr1SortArr[i];
			int times = arr1OnlyMap.get(currentNum);
			
			for (int j = resIndex; j < resIndex + times; j++) {
				res[j] = currentNum;
			}
			resIndex += times;
		}
		
		return res;
	}


	private int handleFirstParty(int[] res, int[] arr1, int[] arr2) {
		int resIndex = 0;
		for (int i = 0; i < arr2.length; i++) {
			int times = 0;
			for (int j = 0; j < arr1.length; j++) {
				if (arr1[j] == arr2[i]) {
					times++;
				}
			}
			for (int k = resIndex; k < resIndex + times; k++) {
				res[k] = arr2[i];
			}
			resIndex += times;
		}
		return resIndex;
	}
	
	private Map<Integer, Integer> getMap(int[] arr1, int[] arr2) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {
			boolean existInArr1 = false;
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					existInArr1 = true;
					break;
				}
				if (j == arr2.length - 1 && !existInArr1) {
					if (map.containsKey(arr1[i])) {
						map.put(arr1[i], map.get(arr1[i]) + 1);
					} else {
						map.put(arr1[i], 1);
					}
				}
			}
		}
		return map;
	}
	

	private int[] getArr(Map<Integer, Integer> arr1OnlyMap) {
		int[] res = new int[arr1OnlyMap.size()];
		int num = 0;
		for (Entry<Integer, Integer> entry : arr1OnlyMap.entrySet()) {
			res[num] = entry.getKey();
			num++;
		}
		
		for (int i = 0; i < res.length - 1; i++) {
			for (int j = 0; j < res.length - 1 - i; j++) {
				if (res[j] > res[j + 1]) {
					int temp = res[j + 1];
					res[j + 1] = res[j];
					res[j] = temp;
				}
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		RelativeSortArray relativeSortArray = new RelativeSortArray();
		int[] res = relativeSortArray.relativeSortArray(new int[] {26,21,11,20,50,34,1,18}, new int[] {21,11,26,20});
		LogUtils.d("ss", res);
	}
}
