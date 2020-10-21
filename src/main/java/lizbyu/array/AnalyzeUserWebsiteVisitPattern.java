package lizbyu.array;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<VisitInfo>> totalInfo = statisticsVisitInfo(username, timestamp, website);
        Set<String> totalWebSequence = new HashSet<>();
        List<Set<String>> webSequenceList = calculateWebSequence(totalInfo, totalWebSequence);

        int maxCount = Integer.MIN_VALUE;
        String res = "";
        for (String sequence : totalWebSequence) {
            int count = 0;
            for (Set<String> visit : webSequenceList) {
                if (visit.contains(sequence)) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                res = sequence;
            } else if (count == maxCount && sequence.compareTo(res) < 0) {
                res = sequence;
            }
        }
        return parserVisit(res);
    }

    private Map<String, List<VisitInfo>> statisticsVisitInfo(String[] username, int[] timestamp, String[] website) {
        Map<String, List<VisitInfo>> totalInfo = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            List<VisitInfo> visitOfPerson = totalInfo.getOrDefault(username[i], new ArrayList<>());
            VisitInfo visitInfo = new VisitInfo(timestamp[i], website[i]);
            visitOfPerson.add(visitInfo);
            totalInfo.put(username[i], visitOfPerson);
        }
        for (Map.Entry<String, List<VisitInfo>> entry : totalInfo.entrySet()) {
            Collections.sort(entry.getValue());
        }
        return totalInfo;
    }

    private List<Set<String>> calculateWebSequence(Map<String, List<VisitInfo>> totalInfo, Set<String> totalWebSequence) {
        List<Set<String>> webSequenceList = new ArrayList<>();
        List<List<String>> originWebVisit = calculateOriginWebVisit(totalInfo);

        for (List<String> list : originWebVisit) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < list.size() - 2; i++) {
                for (int j = i + 1; j < list.size() - 1; j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        String sequence = list.get(i) + "-" + list.get(j) + "-" + list.get(k);
                        set.add(sequence);
                        totalWebSequence.add(sequence);
                    }
                }
            }
            webSequenceList.add(set);
        }

        return webSequenceList;
    }

    private List<List<String>> calculateOriginWebVisit(Map<String, List<VisitInfo>> totalInfo) {
        List<List<String>> originWebVisit = new ArrayList<>();

        for (Map.Entry<String, List<VisitInfo>> entry : totalInfo.entrySet()) {
            List<String> list = new ArrayList<>();
            for (VisitInfo visitInfo : entry.getValue()) {
                list.add(visitInfo.getWebsite());
            }
            originWebVisit.add(list);
        }
        return originWebVisit;
    }


    private List<String> parserVisit(String visitInfo) {
        return Arrays.asList(visitInfo.split("-"));
    }

    private static class VisitInfo implements Comparable<VisitInfo> {
        private final int timestamp;
        private final String website;

        public VisitInfo(int timestamp, String website) {
            this.timestamp = timestamp;
            this.website = website;
        }

        public String getWebsite() {
            return website;
        }

        @Override
        public int compareTo(VisitInfo o) {
            return this.timestamp - o.timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VisitInfo visitInfo = (VisitInfo) o;
            return timestamp == visitInfo.timestamp &&
                    Objects.equals(website, visitInfo.website);
        }

        @Override
        public int hashCode() {
            return Objects.hash(timestamp, website);
        }
    }
}
