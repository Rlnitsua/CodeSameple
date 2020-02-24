package lizbyu.string;

import java.util.ArrayList;
import java.util.List;

import lizbyu.utils.log.LogUtils;

public class FlipGame {
	private static final String TAG = "FlipGame";
	
	public List<String> generatePossibleNextMoves(String s) {
		List<String> strList = new ArrayList<String>();
		if(s == null){
			return strList;
		}
		
		for(int i = 0; i <= s.length() - 2; i++){
			char[] chArray = s.toCharArray();
			if(chArray[i] == '+' && chArray[i] == chArray[i + 1]){
				chArray[i] = '-';
				chArray[i + 1] = '-';
				strList.add(new String(chArray));
			}
		}
		
		return strList;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, new FlipGame().generatePossibleNextMoves("++++"));
	}
}
