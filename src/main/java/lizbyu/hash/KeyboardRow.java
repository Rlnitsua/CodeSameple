package lizbyu.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lizbyu.utils.log.LogUtils;

public class KeyboardRow {
	private static final String TAG = "KeyboardRow";
	
	List<Character> firstRow = Arrays.asList('q', 'w','e', 'r','t', 'y','u', 'i','o', 'p', 
			'Q', 'W','E', 'R','T', 'Y','U', 'I','O', 'P');
	List<Character> secondRow = Arrays.asList('a', 's','d', 'f','g', 'h','j', 'k','l',
			'A', 'S','D', 'F','G', 'H','J', 'K','L');
	List<Character> thirdRow = Arrays.asList('z', 'x','c', 'v','b', 'n','m',
			'Z', 'X','C', 'V','B', 'N','M');
	
	public String[] findWords(String[] words) {
		if(words == null || words.length == 0){
			return words;
		}
		
		List<String> res = new ArrayList<String>();
		
		for(String word : words){
			if(thirdRow.contains(word.toCharArray()[0]) && allContains(thirdRow, word)){
				res.add(word);
			} else if (secondRow.contains(word.toCharArray()[0]) && allContains(secondRow, word)){
				res.add(word);
			} else if (allContains(firstRow, word)){
				res.add(word);
			}
		}
		
		return (String[]) res.toArray(new String[0]);
	}

	private boolean allContains(List<Character> row, String word) {
		for(char ch : word.toCharArray()){
			if(!row.contains(ch)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		LogUtils.d(TAG, new KeyboardRow().findWords(words));
	}
}
