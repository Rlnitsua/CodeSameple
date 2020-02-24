package lizbyu.string;

import lizbyu.utils.log.LogUtils;

public class ReadNCharactersGivenRead4 {
	private static final String TAG = "ReadNCharactersGivenRead4";
	private static final String MESSAGE = "1234567";
	/**
	 * @param buf Destination buffer
	 * @param n Maximum number of characters to read
	 * @return The number of characters read
	 */
	public int read(char[] buf, int n) {
		if(n < 4){
			char[] readBuf = new char[4];
			int length = read4(readBuf);
			
			for(int i = 0; i < n && i < length; i++) {
				buf[i] = readBuf[i];
			}
			
			return n < length ? n : length;
		} else if (n == 4) {
			return read4(buf);
		} else {
			char[] readBuf = new char[4];
			int count = 0;
			int length = 0;
			int lastLength = 0;
			
			while((length = read4(readBuf)) != 0){
				if(n - (4 * count) < 4) {
					int realRead = Math.min(n - (4 * count), length);
					int j = 0;
					for(int i = 0 + (4 * count); i < realRead + (4 * count); i++){
						buf[i] = readBuf[j];
						j++;
					}
					lastLength = realRead;
					break;
				}
				
				if(length == 4) {
					int j = 0;
					for(int i = 0 + (4 * count); i < 4 + (4 * count); i++){
						buf[i] = readBuf[j];
						j++;
					}
					count++;
				} else {
					int j = 0;
					for(int i = 0 + (4 * count); i < length + (4 * count); i++){
						buf[i] = readBuf[j];
						j++;
					}
					lastLength = length;
				}
			}
			
			return (4 * count) + lastLength;
		}
	}

	private int index = 0;
	private int read4(char[] buf) {
		int count = 0;
		int realCount = 0;
		while(count < 4){
			if(index == MESSAGE.length()){
				break;
			} else {
				buf[realCount] = MESSAGE.charAt(index);
				realCount++;
			}
			index++;
			count++;
		}
		return realCount;
	}
	
	public static void main(String[] args) {
		char[] buf = new char[10];
		LogUtils.d(TAG, new ReadNCharactersGivenRead4().read(buf, 6));
		LogUtils.d(TAG, buf);
	}
}
