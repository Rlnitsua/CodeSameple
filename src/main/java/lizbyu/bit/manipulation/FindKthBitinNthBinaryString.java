package lizbyu.bit.manipulation;

public class FindKthBitinNthBinaryString {
    public char findKthBit(int n, int k) {
        return getNBS(n).charAt(k - 1);
    }

    private String getNBS(int n) {
        if (n == 1) {
            return "0";
        }
        String nbs = getNBS(n - 1);
        return nbs + "1" + reverse(invert(nbs));
    }

    private String reverse(String invert) {
        StringBuilder sb = new StringBuilder();
        for (int i = invert.length() - 1; i >= 0; i--) {
            sb.append(invert.charAt(i));
        }
        return sb.toString();
    }

    private String invert(String nbs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nbs.length(); i++) {
            sb.append(nbs.charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }
}
