package rlnitsua.contest;

import rlnitsua.utils.log.LogUtils;

import java.util.*;
import java.util.Map.Entry;

public class InvalidTransactions {
    private static final String TAG = "InvalidTransactions";

    class Transaction implements Comparable<Transaction> {
        private String name;
        private String time;
        private String amount;
        private String city;

        public Transaction(String name, String time, String amount, String city) {
            super();
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Transaction other = (Transaction) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (amount == null) {
                if (other.amount != null)
                    return false;
            } else if (!amount.equals(other.amount))
                return false;
            if (city == null) {
                if (other.city != null)
                    return false;
            } else if (!city.equals(other.city))
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            if (time == null) {
                if (other.time != null)
                    return false;
            } else if (!time.equals(other.time))
                return false;
            return true;
        }

        private InvalidTransactions getOuterType() {
            return InvalidTransactions.this;
        }

        @Override
        public int compareTo(Transaction o) {
            return Integer.valueOf(o.amount);
        }

        @Override
        public String toString() {
            return name + "," + time + "," + amount + "," + city;
        }


    }

    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Transaction>> data = handleSource(transactions);
        List<String> res = new ArrayList<>();

        for (Entry<String, List<Transaction>> d : data.entrySet()) {
            res.addAll(getListFromName(d.getValue()));
        }

        return res;
    }

    private Map<String, List<Transaction>> handleSource(String[] transactions) {
        Map<String, List<Transaction>> list = new HashMap<>();
        for (String source : transactions) {
            String[] data = source.split(",");
            if (list.containsKey(data[0])) {
                list.get(data[0]).add(new Transaction(data[0], data[1], data[2], data[3]));
            } else {
                List<Transaction> l = new ArrayList<>();
                l.add(new Transaction(data[0], data[1], data[2], data[3]));
                list.put(data[0], l);
            }
        }

        for (Entry<String, List<Transaction>> en : list.entrySet()) {
            Collections.sort(en.getValue());
        }
        return list;
    }

    private List<String> getListFromName(List<Transaction> list) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < list.size() - 1; i++) {
            if (Integer.valueOf(list.get(i).amount) > 1000) {
                res.add(list.get(i).toString());
            }

            if (Math.abs(Integer.valueOf(list.get(i).amount) - Integer.valueOf(list.get(i + 1).amount)) < 60
                    && list.get(i).city.equals(list.get(i + 1).city)) {
                if (!res.contains(list.get(i).toString())) {
                    res.add(list.get(i).toString());
                }
                if (!res.contains(list.get(i + 1).toString())) {
                    res.add(list.get(i + 1).toString());
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        InvalidTransactions ind = new InvalidTransactions();
        List<String> res = ind.invalidTransactions(new String[]{"alice,20,800,mtv", "bob,50,1200,mtv"});
        LogUtils.d(TAG, res);
    }
}
