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
		ListNode head = l1;
		while(l1.next != null){
			if(l1.val < l2.val && l2.val < l1.next.val){
				insertAfter(l1, l2);
				l1 = l1.next;
				l2 = l2.next;
			}else {
				l1 = l1.next;
			}
		}
		
		while(l2.next != null){
			insertAfter(l1, l2);
			l2 = l2.next;
		}
		
		insertAfter(l1, l2);
		
		return head;
	}

	private void insertAfter(ListNode l1, ListNode l2) {
		ListNode temp = l2;
		temp.next = l1.next;
		l1.next = temp;
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
		ListNode n6 = new ListNode(9);
		n5.next = n6;
		
		LogUtils.d(TAG, "start");
		new MergeTwoSortedLists().showList(new MergeTwoSortedLists().mergeTwoLists(n1, n5));
	}
	
	private void showList(ListNode node){
		while(node.next != null){
			LogUtils.d(TAG, node.val);
			node = node.next;
		}
	}
}
