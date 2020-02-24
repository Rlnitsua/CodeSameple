package lizbyu.array;

public class RangeAddition {
	public int[] getModifiedArray(int length, int[][] updates) {
		int[] res = new int[length];
		if(updates == null){
			return res;
		}
		
		for(int[] intArr : updates){
			for(int i = intArr[0]; i <= intArr[1]; i++){
				res[i] += intArr[2];
			}
		}
		
		return res;
	}
}
