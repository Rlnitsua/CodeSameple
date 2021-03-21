package rlnitsua.design;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class NumberOfOrdersInTheBacklog {
    public int getNumberOfBacklogOrders(int[][] orders) {
        OrderSystem orderSystem = new OrderSystem();
        for (int[] order : orders) {
            orderSystem.addOrder(order);
        }
        return orderSystem.getCurrentBacklogOrderNumber();
    }

    private static class OrderSystem {
        private final Map<Integer, Integer> buyOrders = new TreeMap<>(new MComparator());
        private final Map<Integer, Integer> sellOrders = new TreeMap<>();

        public void addOrder(int[] order) {
            if (order[2] == 0) {
                addBuyOrder(order[0], order[1]);
            } else {
                addSellOrder(order[0], order[1]);
            }
        }

        private void addBuyOrder(int price, int amount) {
            for (Map.Entry<Integer, Integer> sellOrder : sellOrders.entrySet()) {
                if (sellOrder.getKey() <= price) {
                    int currentStorage = sellOrder.getValue();
                    if (amount >= currentStorage) {
                        sellOrders.put(sellOrder.getKey(), 0);
                        amount -= currentStorage;
                    } else {
                        sellOrders.put(sellOrder.getKey(), currentStorage - amount);
                        amount = 0;
                        break;
                    }
                }
            }

            if (amount > 0) {
                int finalCount = (int) ((buyOrders.getOrDefault(price, 0) + amount)
                        % (Math.pow(10, 9) + 7));
                buyOrders.put(price, finalCount);
            }
        }

        private void addSellOrder(int price, int amount) {
            for (Map.Entry<Integer, Integer> buyOrder : buyOrders.entrySet()) {
                if (buyOrder.getKey() >= price) {
                    int currentStorage = buyOrder.getValue();
                    if (amount >= currentStorage) {
                        buyOrders.put(buyOrder.getKey(), 0);
                        amount -= currentStorage;
                    } else {
                        buyOrders.put(buyOrder.getKey(), currentStorage - amount);
                        amount = 0;
                        break;
                    }
                }
            }

            if (amount > 0) {
                int finalCount = (int) ((sellOrders.getOrDefault(price, 0) + amount)
                                        % (Math.pow(10, 9) + 7));
                sellOrders.put(price, finalCount);
            }
        }

        public int getCurrentBacklogOrderNumber() {
            int num = 0;
            for (int amount : buyOrders.values()) {
                num = (int) ((num + amount) % (Math.pow(10, 9) + 7));
            }
            for (int amount : sellOrders.values()) {
                num = (int) ((num + amount) % (Math.pow(10, 9) + 7));
            }
            return num;
        }

        private static class MComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 >= o2 ? 0 : 1;
            }
        }
    }
}
