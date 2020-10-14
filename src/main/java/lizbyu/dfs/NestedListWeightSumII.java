package lizbyu.dfs;

import java.util.List;

public class NestedListWeightSumII {
	public int depthSumInverse(List<NestedInteger> nestedList) {
		int maxDeep = getMaxDeep(nestedList);
		return depthSumInverse(nestedList, maxDeep);
	}

	private int getMaxDeep(List<NestedInteger> nestedList) {
		int maxDeep = 1;
		
		for(NestedInteger nestedNum : nestedList){
			if(nestedNum.isInteger()){
				continue;
			} else {
				maxDeep = getMaxDeep(nestedNum.getList()) + 1;
			}
		}
		
		return maxDeep;
	}

	private int depthSumInverse(List<NestedInteger> nestedList, int maxDeep) {
		int sum = 0;
		
		for(NestedInteger nestedNum : nestedList){
			if(nestedNum.isInteger()){
				sum += nestedNum.getInteger() * maxDeep;
			} else {
				sum += depthSumInverse(nestedNum.getList(), maxDeep - 1);
			}
		}
		
		return sum;
	}
}