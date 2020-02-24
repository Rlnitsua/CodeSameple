package lizbyu.math;

import lizbyu.utils.log.LogUtils;

public class StrobogrammaticNumber {
	private static final String TAG = "StrobogrammaticNumber";
	
	public boolean isStrobogrammatic(String num) {
		for(int i = 0; i < num.length(); i++){
			if(num.charAt(i) == '6' && num.charAt(num.length() - 1 - i) == '9'){
				continue;
			}else if (num.charAt(i) == '9' && num.charAt(num.length() - 1 - i) == '6'){
				continue;
			}else if(num.charAt(i) == '1' || num.charAt(i) == '0' || num.charAt(i) == '8'){
				if(num.charAt(i) != num.charAt(num.length() - 1 - i)){
					return false;
				}
			}else {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new StrobogrammaticNumber().isStrobogrammatic("1"));
		LogUtils.d(TAG, new StrobogrammaticNumber().isStrobogrammatic("96"));
		LogUtils.d(TAG, new StrobogrammaticNumber().isStrobogrammatic("69"));
		LogUtils.d(TAG, new StrobogrammaticNumber().isStrobogrammatic("818"));
		LogUtils.d(TAG, new StrobogrammaticNumber().isStrobogrammatic("11011"));
		LogUtils.d(TAG, new StrobogrammaticNumber().isStrobogrammatic("96169"));
	}
}
