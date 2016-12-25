package org.uncle.lee.deep.search;

import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

public class NestedListWeightSum {
	private static final String TAG = "NestedListWeightSum";
	
	public int depthSum(List<NestedInteger> nestedList) {
		int depth = 0;
		for(NestedInteger nestedInteger : nestedList){
			depth += calculateDepth(nestedInteger, 1);
		}
		return depth;
	}
	
	private int calculateDepth(NestedInteger nestedInteger, int depth){
		if(nestedInteger.isInteger()){
			return nestedInteger.getInteger() * depth;
		}else {
			int depthSum = 0;
			depth++;
			for(NestedInteger nestedIntegerItem : nestedInteger.getList()){
				depthSum += calculateDepth(nestedIntegerItem, depth);
			}
			return depthSum;
		}
	}
	
	public static void main(String[] args) {
	}
}
