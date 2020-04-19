package lizbyu.contest;

import java.util.*;

public class DisplayTableofFoodOrdersinaRestaurant {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<Order> orderList = new ArrayList<>();
        for (List<String> order : orders) {
            orderList.add(new Order(Integer.valueOf(order.get(1)), order.get(2)));
        }
        Collections.sort(orderList);

        Map<Integer, Map<String, Integer>> info = new TreeMap<>();

        for (Order order : orderList) {
            Map<String, Integer> tableInfo;
            if (info.containsKey(order.getTableID())) {
                tableInfo = info.get(order.getTableID());
                if (tableInfo.containsKey(order.getFoodName())) {
                    tableInfo.put(order.getFoodName(), tableInfo.get(order.getFoodName()) + 1);
                } else {
                    tableInfo.put(order.getFoodName(), 1);
                }
            } else {
                tableInfo = new HashMap<>();
                tableInfo.put(order.getFoodName(), 1);
            }
            info.put(order.getTableID(), tableInfo);

        }

        return calculate(info);
    }


    private List<List<String>> calculate(Map<Integer, Map<String, Integer>> info) {
        List<List<String>> res = new ArrayList<>();

        // handle title
        List<String> title = new ArrayList<>();
        title.add("Talbe");
        List<String> foodNameList = new ArrayList<>();
        for (Map.Entry<Integer, Map<String, Integer>> tableEntry : info.entrySet()) {
            for (Map.Entry<String, Integer> foodEntry : tableEntry.getValue().entrySet()) {
                if (!foodNameList.contains(foodEntry.getKey())) {
                    foodNameList.add(foodEntry.getKey());
                }
            }
        }
        Collections.sort(foodNameList);
        title.addAll(foodNameList);
        res.add(title);

        // handle others
        for (Map.Entry<Integer, Map<String, Integer>> tableEntry : info.entrySet()) {
            List<String> tableList = new ArrayList<>();
            tableList.add(tableEntry.getKey().toString());
            for (int i = 1; i < title.size(); i++) {
                if (tableEntry.getValue().containsKey(title.get(i))) {
                    tableList.add(tableEntry.getValue().get(title.get(i)).toString());
                } else {
                    tableList.add("0");
                }
            }
            res.add(tableList);
        }

        return res;
    }

    private class Order implements Comparable<Order>{
        private int tableID;
        private String foodName;

        public Order(int tableID, String foodName) {
            this.tableID = tableID;
            this.foodName = foodName;
        }

        public int getTableID() {
            return tableID;
        }

        public void setTableID(int tableID) {
            this.tableID = tableID;
        }

        public String getFoodName() {
            return foodName;
        }

        public void setFoodName(String foodName) {
            this.foodName = foodName;
        }

        @Override
        public int compareTo(Order o) {
            return this.tableID - o.tableID;
        }
    }


    public static void main(String[] args) {
        List<List<String>> in = new ArrayList<>();
        in.add(Arrays.asList("CWdAM","10"," FlzD"));
        in.add(Arrays.asList(" T","17","ok"));
        in.add(Arrays.asList("hai ","17","BlXft"));
        in.add(Arrays.asList("cTIg","15","MAvix"));
        in.add(Arrays.asList("jxK","9"," FlzD"));
        in.add(Arrays.asList("vqkCX","14","pLg"));
        in.add(Arrays.asList("qwqB","3","yPsk"));
        in.add(Arrays.asList("YR","15","zG"));
        in.add(Arrays.asList("ovex","11","pLg"));
        in.add(Arrays.asList("zHeWJ","14","TdmVi"));
        in.add(Arrays.asList("L ","9","Ey"));
        in.add(Arrays.asList("lyS","14","zG"));
        in.add(Arrays.asList("vasR","14","ok"));
        in.add(Arrays.asList("NtfZt","14","yPsk"));
        in.add(Arrays.asList("IN","5","xau"));
        in.add(Arrays.asList("GQ","5","bcr"));
        DisplayTableofFoodOrdersinaRestaurant demo = new DisplayTableofFoodOrdersinaRestaurant();
        demo.displayTable(in);
    }
}
