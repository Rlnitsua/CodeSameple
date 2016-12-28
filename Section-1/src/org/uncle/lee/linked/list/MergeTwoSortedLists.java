package org.uncle.lee.linked.list;

import org.uncle.lee.log.LogUtils;

//  Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class MergeTwoSortedLists {
	private static final String TAG = "MergeTwoSortedLists";
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null){
			return l2;
		}else if(l2 == null){
			return l1;
		}
		
		ListNode mergedNode;
		if(l1.val < l2.val){
			mergedNode = l1;
			mergedNode.next = mergeTwoLists(l1.next, l2);
		}else {
			mergedNode = l2;
			mergedNode.next = mergeTwoLists(l1, l2.next);
		}
		return mergedNode;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		ListNode n5 = new ListNode(4);
//		ListNode n6 = new ListNode(9);
//		n5.next = n6;
		
		LogUtils.d(TAG, "start");
		new MergeTwoSortedLists().showList(new MergeTwoSortedLists().mergeTwoLists(n1, n5));
	}
	
	private void showList(ListNode node){
		while(node != null){
			LogUtils.d(TAG, node.val);
			node = node.next;
		}
	}
}
