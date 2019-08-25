package org.uncle.lee.contest;

import java.util.ArrayList;
import java.util.List;

public class Reconstructa2RowBinaryMatrix {
	private static final String TAG = "Reconstructa2RowBinaryMatrix";
	
	private static final int DEFAULT_VALUE = -1;
	
	public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
		List<List<Integer>> res = new ArrayList<>();
		List<List<Integer>> samples = new ArrayList<>();
		List<Integer> basicSample = initBasicSample(colsum);
		
		initSamples(basicSample, colsum, samples);
		
		for (List<List<Integer>> sample : samples) {
			
		}
		return res;
	}


	private List<Integer> initBasicSample(int[] colsum) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private void initSamples(List<Integer> basicSample, int[] colsum, List<List<Integer>> samples) {
		// TODO Auto-generated method stub
		
	}

	private void preHandleMatrix(int[][] matrix, int[] colsum) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = DEFAULT_VALUE;
			}
		}
		for (int i = 0; i < colsum.length; i++) {
			if (colsum[i] == 0) {
				for (int j = 0; j < 2; j++) {
					matrix[j][i] = 0;
				}
			} else if (colsum[i] == 2) {
				for (int j = 0; j < 2; j++) {
					matrix[j][i] = 1;
				}
			}
		}
		
	}

	private boolean isAllDefined(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == DEFAULT_VALUE) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean isValidMatrix(int[][] matrix, int upper, int lower, int[] colsum) {
		for (int i = 0; i < 2; i++) {
			int res = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				res += matrix[i][j];
			}
			if (i == 1 && res != upper) {
				return false;
			} else if (i == 2 && res != lower) {
				return false;
			}
		}
		
		for (int i = 0; i < colsum.length; i++) {
			int res = 0;
			for (int j = 0; j < 2; j++) {
				res += matrix[j][i];
			}
			if (res != colsum[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
	}
}
