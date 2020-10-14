package lizbyu.list;

import lizbyu.utils.log.LogUtils;

public class ReverseLinkedList {
	private static final String TAG = "ReverseLinkedList";
	
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode prev = head;
		ListNode current = head.next;
		prev.next = null;
		ListNode next = null;
				
		while(current != null) {
			// init next value
			next = current.next;
			// do reverse
			current.next = prev;
			// move to next position
			prev = current;
			current = next;
		}
		
		return prev;
	}
	
	private void showLinkedList(ListNode head){
		while(head != null){
			LogUtils.d(TAG, head.val);
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = createLinkedList();
		ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
		ListNode reverseHead = reverseLinkedList.reverseList(head);
		reverseLinkedList.showLinkedList(reverseHead);
	}

	private static ListNode createLinkedList() {
		ListNode node1 = new ReverseLinkedList().new ListNode(1);
		ListNode node2 = new ReverseLinkedList().new ListNode(2);
		node1.next = node2;
		node2.next = null;
		return node1;
	}
}
