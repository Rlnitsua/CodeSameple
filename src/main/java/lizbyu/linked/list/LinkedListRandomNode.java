package lizbyu.linked.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lizbyu.utils.util.ListNode;

public class LinkedListRandomNode {
	private List<Integer> valueList;
	/**
	 * @param head
	 *            The linked list's head. Note that the head is guaranteed to be
	 *            not null, so it contains at least one node.
	 */
	public LinkedListRandomNode(ListNode head) {
		valueList = getValueList(head);
	}

	private List<Integer> getValueList(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while(head != null){
			list.add(head.val);
			head = head.next;
		}
		return list;
	}

	/** Returns a random node's value. */
	public int getRandom() {
		Random random = new Random();
		int randomIndex = random.nextInt(valueList.size());
		return valueList.get(randomIndex);
	}
}
