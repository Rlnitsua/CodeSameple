package lizbyu.bit;

import lizbyu.utils.log.LogUtils;

public class HammingDistance {
	private static final String TAG = "HammingDistance";
	
	public int hammingDistance0(int x, int y) {
		int hammingDistance = 0;
		int result = x ^ y;
		char[] chArray = Integer.toBinaryString(result).toCharArray();
		for(char ch : chArray){
			if(ch == '1'){
				hammingDistance++;
			}
		}
		return hammingDistance;
	}
	
	public int hammingDistance(int x, int y) {
		int hammingDistance = 0;
		int remainder = x ^ y;
		
		while(remainder >= 1){
			if(remainder % 2 == 1){
				hammingDistance++;
			}
			remainder >>= 1;
		}
		
		return hammingDistance;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, Integer.toBinaryString(100));
		LogUtils.d(TAG, "distance : " + new HammingDistance().hammingDistance(1, 4));
		LogUtils.d(TAG, "1 >> 1 = " + (1>>1));;
	}
}
