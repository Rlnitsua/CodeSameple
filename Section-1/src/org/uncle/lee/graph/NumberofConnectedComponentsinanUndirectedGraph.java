package org.uncle.lee.graph;

import java.util.ArrayList;
import java.util.List;

import org.uncle.lee.log.LogUtils;

public class NumberofConnectedComponentsinanUndirectedGraph {
	private static final String TAG = "NumberofConnectedComponentsinanUndirectedGraph";
	private int pointIndex = -1;
	private int xPointIndex = -1;
	private int yPointIndex = -1;
	
	//o(n3)
	public int countComponents(int n, int[][] edges) {
		List<List<Integer>> pointList = new ArrayList<>();

		//o(n)
		for(int row = 0; row < edges.length; row++){
			int xPoint = edges[row][0];
			int yPoint = edges[row][1];
			
			//o(n2)
			if(neitherContainBothPoints(pointList, xPoint, yPoint)){
				List<Integer> newList = new ArrayList<>();
				newList.add(xPoint);
				newList.add(yPoint);
				pointList.add(newList);
				n--;
			} else if (onlyContainFirstPoints(pointList, xPoint, yPoint)){
				pointList.get(pointIndex).add(yPoint);
				n--;
			} else if (onlyContainFirstPoints(pointList, yPoint, xPoint)){
				pointList.get(pointIndex).add(xPoint);
				n--;
			} else if (inDifferentList(pointList, xPoint, yPoint)){
				List<Integer> xList = pointList.get(xPointIndex);
				pointList.get(yPointIndex).addAll(xList);
				pointList.remove(xPointIndex);
				n--;
			} else {
				// inSameList(pointList, xPoint, yPoint)
				// need not handle
			}
		}
		
		return n;
	}

	private boolean neitherContainBothPoints(List<List<Integer>> pointList,
			int xPoint, int yPoint) {
		for(List<Integer> list : pointList){
			if(list.contains(xPoint) || list.contains(yPoint)){
				return false;
			}
		}
		return true;
	}

	private boolean onlyContainFirstPoints(List<List<Integer>> pointList,
			int xPoint, int yPoint) {
		for(List<Integer> list : pointList){
			if(list.contains(yPoint)){
				return false;
			}
		}
		for(int i = 0; i < pointList.size(); i++){
			if(pointList.get(i).contains(xPoint)){
				pointIndex = i;
				return true;
			}
		}
		return false;
	}

	private boolean inDifferentList(List<List<Integer>> pointList, int xPoint,
			int yPoint) {
		for(int i = 0; i < pointList.size(); i++){
			if(pointList.get(i).contains(xPoint)){
				xPointIndex = i;
			}
			if(pointList.get(i).contains(yPoint)){
				yPointIndex = i;
			}
		}
		return xPointIndex != yPointIndex;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, "start");
		NumberofConnectedComponentsinanUndirectedGraph instance = new NumberofConnectedComponentsinanUndirectedGraph();
//		int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}};
		int[][] edges = new int[][]{{0, 1}, {1, 2}, {0, 2}, {3, 4}};
		LogUtils.d(TAG, instance.countComponents(5, edges));
	}
}
