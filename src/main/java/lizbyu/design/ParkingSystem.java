package lizbyu.design;

public class ParkingSystem {
    private final int[] info;

    public ParkingSystem(int big, int medium, int small) {
        this.info = new int[4];
        info[1] = big;
        info[2] = medium;
        info[3] = small;
    }

    public boolean addCar(int carType) {
        if (info[carType] == 0) {
            return false;
        } else {
            info[carType]--;
            return true;
        }
    }
}
