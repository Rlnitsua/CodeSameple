package lizbyu.contest;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] road = new int[1000];

        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int startLocation = trip[1];
            int endLocation = trip[2];

            for (int i = startLocation; i < endLocation; i++) {
                road[i] += numPassengers;
                if (road[i] > capacity) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CarPooling carPooling = new CarPooling();
        int[][] sample0 = new int[][]{{2, 1, 5}, {3, 3, 7}};
        int[][] sample1 = new int[][]{{2, 1, 5}, {3, 3, 7}};
        int[][] sample2 = new int[][]{{2, 1, 5}, {3, 5, 7}};
        int[][] sample3 = new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};

        System.out.println(carPooling.carPooling(sample0, 4));
        System.out.println(carPooling.carPooling(sample1, 5));
        System.out.println(carPooling.carPooling(sample2, 3));
        System.out.println(carPooling.carPooling(sample3, 11));
    }
}
