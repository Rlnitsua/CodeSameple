package lizbyu.math;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		StringBuffer sb = new StringBuffer();
		
		while(n > 0){
			n--;
			int remain = n % 26;
			sb.insert(0, (char)('A' + remain));
			n /= 26;
		}
		
		return new String(sb);
	}
}
