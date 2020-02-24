package lizbyu.linked.list;

import java.util.ArrayList;
import java.util.List;

import lizbyu.utils.log.LogUtils;
import lizbyu.utils.util.ListNode;

public class PalindromeLinkedList {
	private static final String TAG = "PalindromeLinkedList";
	
	public boolean isPalindrome(ListNode head) {
		List<Integer> list = new ArrayList<Integer>();
		while(head != null){
			list.add(head.val);
			head = head.next;
		}
		
		for(int i = 0; i <= ((list.size() - 1) >> 1); i++){
			if(!list.get(i).equals(list.get(list.size() - 1 - i))){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(-129);
		ListNode node2 = new ListNode(-129);
		node1.next = node2;
		LogUtils.d(TAG, new PalindromeLinkedList().isPalindrome(node1));
	}
}
