package org.uncle.lee.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uncle.lee.log.LogUtils;

public class GroupShiftedStrings {
	private static final String TAG = "GroupShiftedStrings";
	
	public List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String str : strings){
			String strTemp = str;
			while(hasNext(strTemp)){
				strTemp = next(strTemp);
			}
			if(map.containsKey(strTemp)){
				map.get(strTemp).add(str);
			}else {
				List<String> listTemp = new ArrayList<String>();
				listTemp.add(str);
				map.put(strTemp, listTemp);
			}
		}
		
		List<List<String>> resultList = new ArrayList<List<String>>();
		for(List<String> valueList : map.values()){
			resultList.add(valueList);
		}
		return resultList;
	}

	private boolean hasNext(String str) {
		return str.charAt(str.length() - 1) != 'z';
	}
	
	private String next(String str) {
		StringBuffer sb = new StringBuffer();
		for(char ch : str.toCharArray()){
			if(ch == 'z'){
				sb.append('a');
			}else {
				sb.append((char)(ch + 1));
			}
		}
		return new String(sb);
	}
	
	public static void main(String[] args) {
		String[] testArgs = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new GroupShiftedStrings().groupStrings(testArgs));
	}
}
