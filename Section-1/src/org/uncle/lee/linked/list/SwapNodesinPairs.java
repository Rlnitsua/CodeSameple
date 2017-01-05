package org.uncle.lee.linked.list;

import org.uncle.lee.log.LogUtils;
import org.uncle.lee.util.ListNode;

public class SwapNodesinPairs {
	private static final String TAG = "SwapNodesinPairs";

	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		
		boolean isFirst = true;
		
		ListNode currentHead = head.next;
		while (head != null && head.next != null
				&& head.next.next != null) {
			if(isFirst){
				swap(head, head.next);
				isFirst = false;
			}else {
				ListNode temp = head.next.next;
				head.next.next = temp.next;
				temp.next = head.next;
				head.next = temp;
				
				head = head.next.next;
			}
		}
		return currentHead;
	}

	private void swap(ListNode head, ListNode next) {
		head.next = next.next;
		next.next = head;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, n1);
		LogUtils.d(TAG, new SwapNodesinPairs().swapPairs(n1));
		
		ListNode n7 = new ListNode(1);
		ListNode n6 = new ListNode(2);
		n7.next = n6;
		LogUtils.d(TAG, new SwapNodesinPairs().swapPairs(n7));
	}
}
