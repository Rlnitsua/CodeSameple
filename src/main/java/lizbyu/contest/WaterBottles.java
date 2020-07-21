package lizbyu.contest;

public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        return calculateBottoles(numBottles, 0, numExchange);
    }

    private int calculateBottoles(int fullBottle, int emptyBottle, int numExchange) {
        if (fullBottle == 0) {
            return 0;
        }

        int newFullBottle = (fullBottle + emptyBottle) / numExchange;
        int newEmptyBottle = (fullBottle + emptyBottle) % numExchange;
        return fullBottle + calculateBottoles(newFullBottle, newEmptyBottle, numExchange);
    }
}
