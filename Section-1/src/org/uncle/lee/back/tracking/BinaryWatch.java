package org.uncle.lee.back.tracking;

import java.util.ArrayList;
import java.util.List;

import org.uncle.lee.log.LogUtils;

public class BinaryWatch {
	private static final String TAG = "BinaryWatch";
	
	// exhaustive is sooo stupid
	public List<String> readBinaryWatch0(int num) {
		List<String> reslutList = new ArrayList<String>();
		
/*		for(...){
			addTimeIntoList(reslutList);
		}*/
		
		return reslutList;
	}
	
	protected void addTimeIntoList(List<String> reslutList, 
			boolean[] hourTag, boolean[] minuteTag){
		String time = calculateTime(hourTag, minuteTag);
		if(time != null){
			reslutList.add(time);
		}
	}
	
	public String calculateTime(boolean[] hourTag, boolean[] minuteTag){
		String hour = calculateHour(hourTag);
		String minute = calculateMinute(minuteTag);
		
		if(hour == null || minute == null){
			return null;
		}else {
			return hour + ":" + minute;
		}
	}

	private String calculateHour(boolean[] hourTag) {
		int hour = 0;
		for(int i = 0; i < 4; i++){
			hour += hourTag[i] ? Math.pow(2, (3 - i)) : 0;
		}
		
		if(hour <= 11){
			return hour < 10 ? String.valueOf(hour%10) : String.valueOf(hour);
		} else {
			return null;
		}
	}
	
	private String calculateMinute(boolean[] minuteTag) {
		int minute = 0;
		for(int i = 0; i < 6; i++){
			minute += minuteTag[i] ? Math.pow(2, (5 - i)) : 0;
		}
		
		if(minute <= 59){
			return String.valueOf(minute);
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		boolean[] hourTag = {false, false, true, true};
		boolean[] minuteTag = {false, true, true, false, false, true};
		
		LogUtils.d(TAG, "start calculate ...");
		LogUtils.d(TAG, "time : " + new BinaryWatch().calculateTime(hourTag, minuteTag));
		
		boolean[] hourTag1 = {true, true, true, true};
		boolean[] minuteTag1 = {false, true, true, true, true, true};
		LogUtils.d(TAG, "start calculate ...");
		LogUtils.d(TAG, "time : " + new BinaryWatch().calculateTime(hourTag1, minuteTag1));
		
		LogUtils.d(TAG, Integer.bitCount(5));
	}
}
