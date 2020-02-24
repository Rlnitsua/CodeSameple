package lizbyu.easy;

import lizbyu.utils.log.LogUtils;

public class FirstBadVersion extends VersionControl {
	private static final String TAG = "FirstBadVersion";
	
	public int firstBadVersion(int n) {
		int lo = 1, hi = n;
		
		while(lo < hi){
			int mid = lo + ((hi - lo) >> 1);
			if(isBadVersion(mid)){
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		
		return lo;
	}
	
	public int getFristBadVersion(int lo, int hi){
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