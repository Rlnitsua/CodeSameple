package org.uncle.lee.binary.tree;

import java.util.ArrayList;
import java.util.List;

import org.uncle.lee.util.TreeNode;

public class AverageofLevelsinBinaryTree {
	public List<Double> averageOfLevels(TreeNode root) {
		if(root == null) {
			return null;
		}
		
		List<TreeNode> nodeList = new ArrayList<>();
		nodeList.add(root);
		List<Double> res =  new ArrayList<>();
		calculateAverage(nodeList, res);
		return res;
	}

	private void calculateAverage(List<TreeNode> nodeList, List<Double> res) {
		if(nodeList.size() == 0) {
			return;
		}
		
		double sum = 0;
		List<TreeNode> nextNodeList = new ArrayList<>();
		for(TreeNode node : nodeList) {
			sum += node.val;
			
			if(node.left != null) {
				nextNodeList.add(node.left);
			}
			if(node.right != null) {
				nextNodeList.add(node.right);
			}
		}
		res.add(sum / nodeList.size());
		
		calculateAverage(nextNodeList, res);
	}
}
