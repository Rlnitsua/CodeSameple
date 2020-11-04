package rlnitsua.design;

import rlnitsua.utils.log.LogUtils;

import java.util.*;

class LogSystem {
    private Map<String, List<Integer>> logMap;

    public LogSystem() {
        logMap = new HashMap<>();
    }

    public void put(int id, String timestamp) {
        if (logMap.containsKey(timestamp)) {
            logMap.get(timestamp).add(id);
        } else {
            List<Integer> idList = new ArrayList<>();
            idList.add(id);
            logMap.put(timestamp, idList);
        }
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<String> timestampList = getTargetList(s, e, gra);
        return getIdList(timestampList);
    }

    private List<String> getTargetList(String s, String e, String gra) {
        Set<String> originTimestamp = logMap.keySet();
        List<String> targetTimestamp = new ArrayList<>();
        for (String origin : originTimestamp) {
            if (isLegalTimestamp(origin, s, e, gra)) {
                targetTimestamp.add(origin);
            }
        }
        return targetTimestamp;
    }

    private boolean isLegalTimestamp(String origin, String s, String e, String gra) {
        TimeStamp startTimeStamp = new TimeStamp(s, gra);
        TimeStamp endTimeStamp = new TimeStamp(e, gra);
        TimeStamp originTimeStamp = new TimeStamp(origin, gra);
        return startTimeStamp.compareTo(originTimeStamp) <= 0 &&
                originTimeStamp.compareTo(endTimeStamp) <= 0;
    }

    private List<Integer> getIdList(List<String> timestampList) {
        List<Integer> idList = new ArrayList<>();
        for (String timestamp : timestampList) {
            idList.addAll(logMap.get(timestamp));
        }
        return idList;
    }

    private class TimeStamp implements Comparable<TimeStamp> {
        private String gra;
        private String origin;

        public TimeStamp(String origin, String gra) {
            this.origin = origin;
            this.gra = gra;
        }

        public String getOrigin() {
            return origin;
        }

        @Override
        public int compareTo(TimeStamp target) {
            int endIndex = 0;
            switch (gra) {
                case "Year":
                    endIndex = 4;
                    break;
                case "Month":
                    endIndex = 7;
                    break;
                case "Day":
                    endIndex = 10;
                    break;
                case "Hour":
                    endIndex = 13;
                    break;
                case "Minute":
                    endIndex = 16;
                    break;
                case "Second":
                    endIndex = 19;
                    break;
            }
            origin = origin.substring(0, endIndex);
            String targetStr = target.getOrigin().substring(0, endIndex);

            return origin.compareTo(targetStr);
        }
    }
}

public class DesignLogStorageSystem {
    private static final String TAG = "DesignLogStorageSystem";

    public static void main(String[] args) {
        LogSystem logSystem = new LogSystem();

        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:01:22:59:59");
        logSystem.put(3, "2016:01:01:00:00:00");

        List<Integer> retrieve1 = logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year");
        LogUtils.d(TAG, retrieve1);
        List<Integer> retrieve2 = logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour");
        LogUtils.d(TAG, retrieve2);
    }
}