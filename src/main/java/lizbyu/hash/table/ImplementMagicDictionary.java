package lizbyu.hash.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lizbyu.utils.log.LogUtils;

public class ImplementMagicDictionary {
	private static final String TAG = "ImplementMagicDictionary";
	
	class MagicDictionary {
		private Map<Integer, List<String>> map;

		/** Initialize your data structure here. */
		public MagicDictionary() {
			map = new HashMap<>();
		}

		/** Build a dictionary through a list of words */
		public void buildDict(String[] dict) {
			for (String item : dict) {
				if (map.containsKey(item.length())) {
					map.get(item.length()).add(item);
				} else {
					List<String> list = new ArrayList<>();
					list.add(item);
					map.put(item.length(), list);
				}
			}
		}

		/**
		 * Returns if there is any word in the trie that equals to the given word after
		 * modifying exactly one character
		 */
		public boolean search(String word) {
			if (map.containsKey(word.length())) {
				return compareWord(word, map.get(word.length()));
			} else {
				return false;
			}
		}

		private boolean compareWord(String word, List<String> list) {
			for (String item : list) {
				if (isValidStr(word, item)) {
					return true;
				}
			}
			return false;
		}

		private boolean isValidStr(String word, String item) {
			char[] wordArr = word.toCharArray();
			char[] itemArr = item.toCharArray();
			int diffCount = 0;
			for (int i = 0; i < word.length(); i++) {
				if (wordArr[i] != itemArr[i]) {
					diffCount++;
				}
				if (diffCount == 2) {
					return false;
				}
			}
			return diffCount == 1;
		}
	}
	
	public static void main (String[] args) {
		ImplementMagicDictionary imp = new ImplementMagicDictionary();
		MagicDictionary dic = imp.new MagicDictionary();
		dic.buildDict(new String[] {"hello", "leetcode"});
		LogUtils.d(TAG, dic.search("hello"));
		LogUtils.d(TAG, dic.search("hhllo"));
		LogUtils.d(TAG, dic.search("hell"));
		LogUtils.d(TAG, dic.search("leetcoded"));
	}
}
