package lizbyu.utils.util;

public class ListNodeCreater {
	
	public static ListNode create(String str){
		String[] values = str.replace(" ", "").split(",");
		
		if(values == null || values.length == 0){
			throw new IllegalArgumentException("list values is error");
		}
		
		ListNode node = new ListNode(Integer.parseInt(values[0]));
		ListNode nodeTemp = node;
		
		for(int i = 1; i < values.length; i++){
			ListNode nodex = new ListNode(Integer.parseInt(values[i]));
			node.next = nodex;
			node = node.next;
		}
		
		return nodeTemp;
	}
}
