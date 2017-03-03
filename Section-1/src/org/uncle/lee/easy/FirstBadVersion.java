package org.uncle.lee.easy;

import org.uncle.lee.log.LogUtils;

public class FirstBadVersion extends VersionControl {
	private static final String TAG = "FirstBadVersion";
	
	public int firstBadVersion(int n) {
		return getFristBadVersion(0, n);
	}
	
	private int getFristBadVersion(int lo, int hi){
		int mid = 0;
		if(lo < hi){
			mid = lo + (hi - lo) >> 1;
		
			if(isBadVersion(mid)){
				// <--
				return getFristBadVersion(lo, mid);
			} else {
				// -->
				return getFristBadVersion(mid + 1, hi);
			}
		}
		
		return lo;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, new FirstBadVersion().firstBadVersion(3));
	}
}

class VersionControl {
	private final int FIRST_BADE_VERSION = 2;

	boolean isBadVersion(int version){
		return version >= FIRST_BADE_VERSION;
	}
}