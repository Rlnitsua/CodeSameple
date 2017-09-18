package org.uncle.lee.math;

import org.uncle.lee.log.LogUtils;

public class QuirrelSimulation {
	private static final String TAG = "QuirrelSimulation";
	
	public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
		int firstDistance = 0;
		int otherDistance = 0;
		int res = Integer.MAX_VALUE;
		
		for (int i = 0; i < nuts.length; i++) {
			if (nuts[i][0] >= height && nuts[i][1] >= width) {
				continue;
			}
			firstDistance = getFirstDistance(squirrel, tree, nuts[i]);
			for (int j = 0; j < nuts.length; j++) {
				if (j != i) {
					if (nuts[i][0] >= height && nuts[i][1] >= width) {
						continue;
					}
					otherDistance += getNutsDistance(tree, nuts[j]);
				}
			}
			res = Math.min(res, firstDistance + otherDistance);
			otherDistance = 0;
		}
		
		firstDistance = getFirstDistance(squirrel, tree);
		for (int i = 0; i < nuts.length; i++) {
			otherDistance += getNutsDistance(tree, nuts[i]);
		}
		res = Math.min(res, firstDistance + otherDistance);
		
		return res;
	}
	
	private int getFirstDistance(int[] squirrel, int[] tree) {
		return Math.abs(squirrel[0] - tree[0]) + Math.abs(squirrel[1] - tree[1]);
	}

	private int getFirstDistance(int[] squirrel, int[] tree, int[] nut) {
		return getFirstDistance(squirrel, nut) + getFirstDistance(nut, tree);
	}

	private int getNutsDistance(int[] tree, int[] nut) {
		return getFirstDistance(tree, nut) * 2;
	}
	
	public static void main(String[] args) {
		int[] tree = {2, 2};
		int[] squirrel = {4, 4};
		int[][] nuts = {{3, 0}, {2, 5}, {8, 2}};
		LogUtils.d(TAG, new QuirrelSimulation().minDistance(5, 7, tree, squirrel, nuts));
	}
}
