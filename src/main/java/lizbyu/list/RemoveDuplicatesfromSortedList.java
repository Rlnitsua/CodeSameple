package lizbyu.list;

import lizbyu.utils.log.LogUtils;

public class RemoveDuplicatesfromSortedList {
	private static final String TAG = "RemoveDuplicatesfromSortedList";
	
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null){
			return head;
		}
		ListNode newHead = head;
		
		while(head.next != null){
			if(head.val == head.next.val){
				head.next = head.next.next;
			}else {
				head = head.next;
			}
		}
		
		return newHead;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new RemoveDuplicatesfromSortedList().new ListNode(1);
		ListNode node2 = new RemoveDuplicatesfromSortedList().new ListNode(2);
		ListNode node3 = new RemoveDuplicatesfromSortedList().new ListNode(2);
		ListNode node4 = new RemoveDuplicatesfromSortedList().new ListNode(4);
		ListNode node5 = new RemoveDuplicatesfromSortedList().new ListNode(5);
		ListNode node6 = new RemoveDuplicatesfromSortedList().new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
//		ListNode newHead = node1;
//		node1 = node1.next;
//		LogUtils.d(TAG, "node1.value : " + node1.val);
//		LogUtils.d(TAG, "new Head value : " + newHead.val);
		LogUtils.d(TAG, "start");
		showListNode(node1);
		showListNode(new RemoveDuplicatesfromSortedList().deleteDuplicates(node1));
	}

	private static void showListNode(ListNode head) {
		while(head != null){
			LogUtils.d(TAG, head.val);
			head = head.next;
		}
	}
}
