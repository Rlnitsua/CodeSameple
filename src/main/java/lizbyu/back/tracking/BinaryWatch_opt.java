package lizbyu.back.tracking;

import java.util.ArrayList;
import java.util.List;

import lizbyu.utils.log.LogUtils;

public class BinaryWatch_opt {
	private static final String TAG = "BinaryWatch_opt";
	
	public List<String> readBinaryWatch(int num) {
		List<String> resultList = new ArrayList<String>();
		
		for(int hour = 0; hour < 12; hour++){
			for(int minute = 0; minute < 60; minute++){
				if(Integer.bitCount(hour) + Integer.bitCount(minute) == num){
					resultList.add(String.format("%d:%02d", hour, minute));
				}
			}
		}
		return resultList;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, new BinaryWatch_opt().readBinaryWatch(6));
	}
}
