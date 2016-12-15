package org.uncle.lee.hash.table;

public class NumberOfBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
		int numbers = 0;
		int maxSize = points.length;
		double[][] distances = getDistances(points);
		
		for(int i = 0; i < maxSize; i++){
			for(int j = 0; j < maxSize; j++){
				for(int k = 0; k < maxSize; k++){
					if(j != k && distances[i][j] == distances[i][k]){
						numbers++;
					}
				}
			}
		}
		
		return numbers;
	}

	private double[][] getDistances(int[][] points) {
		int maxSize = points.length;
		double[][] distances = new double[maxSize][maxSize];
		
		for(int i = 0; i < maxSize; i++){
			for(int j = 0; j < maxSize; j++){
				distances[i][j] = calculateDistance(points[i], points[j]);
			}
		}
		
		return distances;
	}

	private double calculateDistance(int[] point1, int[] point2) {
		int px1 = point1[0]; int py1 = point1[1];
		int px2 = point2[0]; int py2 = point2[1];
		
		return Math.sqrt( (py1 - py2) * (py1 - py2) + (px1 - px2) * (px1 - px2) );
	}

	public static void main(String[] args) {
		// answer = 20
		int[][] array = { { 0, 0 }, { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
//		int[][] array = { {0, 0 }, {1, 0}, {2, 0}};
		System.out.println(new NumberOfBoomerangs().numberOfBoomerangs(array));
	}
}
