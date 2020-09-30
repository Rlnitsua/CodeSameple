package lizbyu.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lizbyu.utils.log.LogUtils;

public class MinimumIndexSumofTwoLists {
	private static final String TAG = "MinimumIndexSumofTwoLists";
	
	public String[] findRestaurant(String[] list1, String[] list2) {
		HashMap<Integer, List<String>> map = new HashMap<>();
		
		for(int index1 = 0; index1 < list1.length; index1++) {
			for(int index2 = 0; index2 < list2.length; index2++) {
				if(list1[index1].equals(list2[index2])) {
					if(map.get(index1 + index2) == null) {
						ArrayList<String> arrayList = new ArrayList<>();
						arrayList.add(list1[index1]);
						map.put(index1 + index2, arrayList);
					} else {
						map.get(index1 + index2).add(list1[index1]);
					}
					break;
				}
			}
		}
		
		int minNum = Integer.MAX_VALUE;
		for(int num : map.keySet()) {
			minNum = Math.min(minNum, num);
		}

		List<String> resList = map.get(minNum);
		String[] res = new String[resList.size()];
		for(int i = 0 ; i < res.length; i++) {
			res[i] = resList.get(i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
		String[] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
		
		LogUtils.d(TAG, new MinimumIndexSumofTwoLists().findRestaurant(list1, list2));;
	}
}
