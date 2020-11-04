package lizbyu.array;

public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxTime = releaseTimes[0];
        char target = keysPressed.charAt(0);

        for (int i = 1; i < releaseTimes.length; i++) {
            if (releaseTimes[i] - releaseTimes[i - 1] > maxTime) {
                maxTime = releaseTimes[i] - releaseTimes[i - 1];
                target = keysPressed.charAt(i);
            } else if (releaseTimes[i] - releaseTimes[i - 1] == maxTime
                && keysPressed.charAt(i) > target) {
                target = keysPressed.charAt(i);
            }
        }
        return target;
    }
}
