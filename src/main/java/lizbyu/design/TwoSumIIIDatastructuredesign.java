package lizbyu.design;

import java.util.ArrayList;
import java.util.List;

import lizbyu.utils.log.LogUtils;

@Deprecated
public class TwoSumIIIDatastructuredesign {
	private static final String TAG = "TwoSumIIIDatastructuredesign";

	private List<Integer> numList;
	private List<Integer> sumList;
	
	/** Initialize your data structure here. */
	public TwoSumIIIDatastructuredesign() {
		numList = new ArrayList<Integer>();
		sumList = new ArrayList<Integer>();
	}

	/** Add the number to an internal data structure.. */
	public void add(int number) {
		for(int num : numList){
//			if(!sumList.contains(num + number)){
			sumList.add(num + number);
//			}
		}
		
		numList.add(number);
	}

	/**
	 * Find if there exists any pair of numbers which sum is equal to the value.
	 */
	public boolean find(int value) {
		return sumList.contains(value);
	}
	
	public static void main(String[] args) {
		TwoSumIIIDatastructuredesign twoSumIIIDatastructuredesign = new TwoSumIIIDatastructuredesign();
		twoSumIIIDatastructuredesign.add(0);
		twoSumIIIDatastructuredesign.add(0);
		twoSumIIIDatastructuredesign.add(0);
		LogUtils.d(TAG, twoSumIIIDatastructuredesign.find(0));
	}
}
