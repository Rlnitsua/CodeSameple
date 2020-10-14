package lizbyu.design;

import lizbyu.utils.log.LogUtils;

public class Codec {
    private static final String TAG = "Codec";
    private static final String SPLIT = "//";
    private static final String OUTPUT_CONTENT = "tinyurl.com/";
    private String head;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        head = longUrl.trim().split(SPLIT)[0];
        String message = getMessage(longUrl);
        StringBuffer sb = new StringBuffer();

        for (char ch : message.toCharArray()) {
            sb.append(String.valueOf((int) ch));
        }

        return head + SPLIT + OUTPUT_CONTENT + new String(sb);
    }

    private String getMessage(String longUrl) {
        return longUrl.trim().split(SPLIT)[1];
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String encodeMessage = getEncodeMessage(shortUrl);
        char[] chArray = encodeMessage.toCharArray();
        int index = 0;
        StringBuffer sb = new StringBuffer();

        while (index < chArray.length) {
            if (chArray[index] != '1') {
                sb.append(getDecodeCh(chArray, index, 2));
                index += 2;
            } else {
                sb.append(getDecodeCh(chArray, index, 3));
                index += 3;
            }
        }

        return head + SPLIT + new String(sb);
    }

    private String getEncodeMessage(String shortUrl) {
        return shortUrl.trim().substring((head + SPLIT + OUTPUT_CONTENT).length());
    }

    private char getDecodeCh(char[] chArray, int index, int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            sb.append(chArray[index + i]);
        }
        return (char) ((int) (Integer.valueOf(new String(sb))));
    }

    public static void main(String[] args) {
//		String longUrl = "https://leetcode.com/problems/design-tinyurl";
        String longUrl = "http://alc";
        Codec codec = new Codec();
        String encodeUrl = codec.encode(longUrl);
        LogUtils.d(TAG, encodeUrl);
        LogUtils.d(TAG, codec.decode(encodeUrl));
    }
}
