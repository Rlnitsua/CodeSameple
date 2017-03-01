package org.uncle.lee.math;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		StringBuffer sb = new StringBuffer();
		
		while(n > 0){
			if(n - 26 > 0){
				sb.append("Z");
			}
			n -= 26;
		}
		
		return new String(sb);
	}
}
