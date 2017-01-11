package org.uncle.lee.linked.list;

import org.uncle.lee.log.LogUtils;
import org.uncle.lee.util.ListNode;

public class LinkedListCycle {
	private static final String TAG = "LinkedListCycle";

	public boolean hasCycle(ListNode head) {
		if(head == null){
			return false;
		}
		
		ListNode slower = head;
		ListNode faster = head;
		
		while(faster.next != null && faster.next.next != null){
			slower = slower.next;
			faster = faster.next.next;
			if(slower == faster){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new LinkedListCycle().hasCycle(null));
	}
}
