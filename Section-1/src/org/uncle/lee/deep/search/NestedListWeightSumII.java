package org.uncle.lee.deep.search;

import java.util.List;

public class NestedListWeightSumII {
	public int depthSumInverse(List<NestedInteger> nestedList) {
		int maxDeep = 0;
		for(NestedInteger nestedI : nestedList){
			maxDeep = Math.max(maxDeep, getMaxDeep(nestedI, 1));
		}
		
		int sum = 0;
		for(NestedInteger nestedI : nestedList){
			sum += calculateSum(nestedI, maxDeep + 1, 0);
		}
		return sum;
	}
	
	private int getMaxDeep(NestedInteger nestedNum, int maxDeep) {
		if(nestedNum.isInteger()){
			return maxDeep;
		} else {
			for(NestedInteger nestedEle : nestedNum.getList()){
				maxDeep = Math.max(maxDeep, getMaxDeep(nestedEle, maxDeep - 1));
			}
		}
		return maxDeep;
	}

	private int calculateSum(NestedInteger nestedNum, int deep, int sum){
		if(nestedNum.isInteger()){
			sum += nestedNum.getInteger() * deep;
		} else {
			for(NestedInteger nestedEle : nestedNum.getList()){
				sum += calculateSum(nestedEle, deep + 1, sum);
			}
		}
		return sum;
	}
}