package rlnitsua.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndergroundSystem {
    private Map<String, List<Integer>> data;
    private List<Info> checkInInfo;

    public UndergroundSystem() {
        data = new HashMap<>();
        checkInInfo = new ArrayList<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInInfo.add(new Info(id, stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        int checkInIndex = -1;
        for (int i = 0; i < checkInInfo.size(); i++) {
            Info currentCheckInInfo = checkInInfo.get(i);
            if (currentCheckInInfo.getId() == id) {
                checkInIndex = i;
                String stationTag = currentCheckInInfo.getStartStationName() + stationName;
                if (data.containsKey(stationTag)) {
                    List<Integer> durationList = data.get(stationTag);
                    durationList.add(t - currentCheckInInfo.getStartTime());
                    data.put(stationTag, durationList);
                } else {
                    List<Integer> durationList = new ArrayList<>();
                    durationList.add(t - currentCheckInInfo.getStartTime());
                    data.put(stationTag, durationList);
                }
                break;
            }
        }
        checkInInfo.remove(checkInIndex);
    }

    public double getAverageTime(String startStation, String endStation) {
        double averageTime = 0;

        if (data.containsKey(startStation + endStation)) {
            List<Integer> durationList = data.get(startStation + endStation);
            double sum = 0;
            for (Integer duration : durationList) {
                sum += duration;
            }
            averageTime = sum / durationList.size();
        }

        return averageTime;
    }

    private class Info {
        private int id;
        private String startStationName;
        private int startTime;

        public Info(int id, String startStationName, int startTime) {
            this.id = id;
            this.startStationName = startStationName;
            this.startTime = startTime;
        }

        public int getId() {
            return id;
        }

        public String getStartStationName() {
            return startStationName;
        }

        public int getStartTime() {
            return startTime;
        }
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        double averageTime = undergroundSystem.getAverageTime("Paradise", "Cambridge");// return 14.0. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        double averageTime1 = undergroundSystem.getAverageTime("Leyton", "Waterloo");// return 11.0. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.0
        undergroundSystem.checkIn(10, "Leyton", 24);
        double averageTime2 = undergroundSystem.getAverageTime("Leyton", "Waterloo");// return 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);
        double averageTime3 = undergroundSystem.getAverageTime("Leyton", "Waterloo");
        int x = 0;
    }
}
