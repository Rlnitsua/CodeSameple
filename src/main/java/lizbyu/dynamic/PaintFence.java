package lizbyu.dynamic;

public class PaintFence {
	
	
	public int numWays(int n, int k) {
		if(n == 0){
			return 0;
		} else if (n == 1){
			return k;
		}
		
		int[] res = new int[n];
		res[0] = k;
		res[1] = k * k;
		
		for(int i = 2; i < n; i++){
			res[i] = res[i-1] * (k - 1) + res[i-2] * (k - 1);
		}
		
		return res[n - 1];
	}

}
