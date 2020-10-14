package lizbyu.tracking;

import lizbyu.utils.log.LogUtils;

public class FlipGameII {
    private static final String TAG = "FlipGameII";

    public boolean canWin(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);

                if (!canWin(t)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "start");
//		String msg = "++++--+-+---+++-+-+-+++--++-+-+++---+-+-";
        String msg = "+++++";
        FlipGameII flipGameII = new FlipGameII();
        LogUtils.d(TAG, flipGameII.canWin(msg));
    }
}
