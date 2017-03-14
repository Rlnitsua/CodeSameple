package org.uncle.lee.back.tracking;

@Deprecated
public class BeautifulArrangement {
	public int countArrangement(int N) {
		if(N == 2){
			return 2;
		}
		
		int count = 0;
		int[] arr = new int[N];
		
		for(int i = 1; i <= N; i++){
			arr[i - 1] = i;
		}
		
		for(int i = 1; i <= N; i++){
			for(int j = 2; j <= N; j++){
				if(i * j <= arr[N - 1]){
					count += 2;
				} else {
					break;
				}
			}
		}
		
		return count;
	}
}
