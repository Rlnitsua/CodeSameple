package lizbyu.array;

public class TeemoAttacking {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		if(timeSeries == null || timeSeries.length == 0){
			return 0;
		}
		
		int poisonedDuration = 0;
		for(int i = 1; i < timeSeries.length; i++){
			if(timeSeries[i] - timeSeries[i - 1] < duration){
				poisonedDuration += timeSeries[i] - timeSeries[i - 1];
			} else {
				poisonedDuration += duration;
			}
		}
		return poisonedDuration + duration;
	}
}
