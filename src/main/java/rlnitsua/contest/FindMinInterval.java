package rlnitsua.contest;

import java.util.*;

public class FindMinInterval {
    private int startIndex = 0;

    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] res = new int[queries.length];
        Map<Integer, Integer> cache = new HashMap<>();
        List<Interval> list = new ArrayList<>();

        for (int[] interval : intervals) {
            list.add(new Interval(interval[0], interval[1]));
        }
        Collections.sort(list);

        for (int i = 0; i < res.length; i++) {
            if (cache.containsKey(queries[i])) {
                res[i] = cache.get(queries[i]);
            } else {
                res[i] = calculateMinInterval(list, queries[i]);
                cache.put(queries[i], res[i]);
            }
        }
        return res;
    }

    private int calculateMinInterval(List<Interval> intervals, int query) {
        int minInterval = Integer.MAX_VALUE;
        // find start position
        int l = -1;
        int r = intervals.size();

        while (l != r - 1) {
            int mid = (l + r) / 2;
            if (intervals.get(mid).start > query) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (r == 0) {
            return -1;
        }

        List<IntervalEnd> endList = calculateEndList(intervals, l, query);

        for (int i = startIndex; i < endList.size(); i++) {
            IntervalEnd interval = endList.get(i);
            if (interval.end >= query) {
                minInterval = Math.min(minInterval, interval.end - interval.start + 1);
            }
        }

        return minInterval == Integer.MAX_VALUE ? -1 : minInterval;
    }

    private List<IntervalEnd> calculateEndList(List<Interval> intervals, int last, int query) {
        List<IntervalEnd> endList = new ArrayList<>();

        for (int i = 0; i <= last; i++) {
            Interval interval = intervals.get(i);
            endList.add(new IntervalEnd(interval.start, interval.end));
        }

        Collections.sort(endList);

        int l = -1;
        int r = endList.size();
        while (l != r - 1) {
            int mid = (l + r) / 2;
            if (endList.get(mid).end < query) {
                l = mid;
            } else {
                r = mid;
            }
        }
        startIndex = r;

        return endList;
    }

    private static class Interval implements Comparable<Interval>{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return this.start - o.start;
        }
    }

    private static class IntervalEnd implements Comparable<IntervalEnd> {
        int start;
        int end;

        public IntervalEnd(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(IntervalEnd o) {
            return this.end - o.end;
        }
    }
}
