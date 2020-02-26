package lizbyu.utils.log;

import java.util.Arrays;
import java.util.List;

import lizbyu.utils.time.TimeUtils;
import lizbyu.utils.node.ListNode;
import lizbyu.utils.node.TreeNode;

public  class  LogUtils{
	public static void d(String TAG, Object xMsg){
		String logLevel = "D/";
		String content = constructLogContent(logLevel, TAG, xMsg + "");
		System.out.println(content);
	}
	
	public static void d(String TAG, String msg){
		String logLevel = "D/";
		String content = constructLogContent(logLevel, TAG, msg);
		System.out.println(content);
	}
	
	public static void e(String TAG, String msg){
		String logLevel = "E/";
		String content = constructLogContent(logLevel, TAG, msg);
		System.out.println(content);
	}
	
	public static void d(String TAG, List<?> list){
		String logLevel = "D/";
		String msg = Arrays.toString(list.toArray());
		String content = constructLogContent(logLevel, TAG, msg);
		System.out.println(content);
	}
	
	public static void d(String TAG, int[] array){
		String logLevel = "D/";
		String msg = Arrays.toString(array);
		String content = constructLogContent(logLevel, TAG, msg);
		System.out.println(content);
	}
	
	public static void d(String TAG, char[] chArray){
		String logLevel = "D/";
		String msg = Arrays.toString(chArray);
		String content = constructLogContent(logLevel, TAG, msg);
		System.out.println(content);
	}
	
	public static void d(String TAG, Object[] array){
		String logLevel = "D/";
		String msg = Arrays.toString(array);
		String content = constructLogContent(logLevel, TAG, msg);
		System.out.println(content);
	}
	
	public static void d(String TAG, int[][] array){
		String logLevel = "D/";
		String msg = getTwoDimensionArrayMsg(array);
		String content = constructLogContent(logLevel, TAG, msg);
		System.out.println(content);
	}
	
	private static String getTwoDimensionArrayMsg(int[][] array) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i = 0; i < array.length; i++){
			sb.append(Arrays.toString(array[i]));
		}
		sb.append("]");
		return new String(sb);
	}
	
	public static void d(String TAG, ListNode node){
		String logLevel = "D/";
		String msg = getListNodeValues(node);
		String content = constructLogContent(logLevel, TAG, msg);
		System.out.println(content);
	}
	
	private static String getListNodeValues(ListNode node) {
		if(node == null){
			return null;
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		while(node != null){
			sb.append(node.val + "->");
			node = node.next;
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append("]");
		return new String(sb);
	}
	
	public static void d(String TAG, TreeNode node){
		String logLevel = "D/";
		String msg = getTreeNodeValues(node);
		String content = constructLogContent(logLevel, TAG, msg);
		System.out.println(content);
	}

	private static String getTreeNodeValues(TreeNode node) {
		return treeNodeValues(node);
	}

	private static String treeNodeValues(TreeNode node) {
		if(node == null){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(node.val + " ");
		sb.append(treeNodeValues(node.left));
		sb.append(treeNodeValues(node.right));
		return new String(sb);
	}

	private static String constructLogContent(String logLevel, String TAG, String msg) {
		StringBuffer sb = new StringBuffer();
		sb.append(getCurrentTime());
		sb.append(logLevel);
		sb.append(getTagMessage(TAG));
		sb.append(msg);
		return new String(sb);
	}

	private static String getCurrentTime() {
		return TimeUtils.getCurrentTime();
	}
	
	private static String getTagMessage(String TAG) {
		return TAG + ": ";
	}
}
