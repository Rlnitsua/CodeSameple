package lizbyu.linked.list;

import lizbyu.utils.log.LogUtils;
import lizbyu.utils.util.ListNode;
import lizbyu.utils.util.ListNodeCreater;

public class IntersectionofTwoLinkedLists {
	private static final String TAG = "IntersectionofTwoLinkedLists";
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null){
			return null;
		}
		
		int aLength = getLength(headA);
		int bLength = getLength(headB);
		
		if(getNode(headA, aLength - 1) != getNode(headB, bLength - 1)) {
			return null;
		}
		
		int minLength = Math.min(aLength, bLength);
		
		if(minLength == 1) {
			return getNode(headA, aLength - 1);
		}
		
		for(int i = 1; i < minLength; i++) {
			if(getNode(headA, aLength - i) == getNode(headB, bLength - i) &&
					getNode(headA, aLength - i - 1) != getNode(headB, bLength - i - 1)) {
				return getNode(headA, aLength - i);
			}
		}
		
		// all element is equal
		return getNode(headA, aLength - minLength);
	}
	
	private ListNode getNode(ListNode head, int index){
		ListNode headTemp = head;
		while(headTemp != null && index > 0){
			headTemp = headTemp.next;
			index--;
		}
		return headTemp;
	}
	
	private int getLength(ListNode head) {
		ListNode headTemp = head;
		int length = 0;
		while(headTemp != null) {
			headTemp = headTemp.next;
			length++;
		}
		return length;
	}
	
	public static void main(String[] args) {
//		ListNode headA = ListNodeCreater.create("1,2,3,4,5,6,7,8,9,10,11,12,13");
//		ListNode headB = headA;
		
		ListNode intersectionNode = ListNodeCreater.create("6,7,8,9,10");
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = intersectionNode;
		

		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(4);
		node4.next = node5;
		node5.next = intersectionNode;
		
		
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new IntersectionofTwoLinkedLists().getIntersectionNode(node1, node4));
	}
}
