package lizbyu.design;

import lizbyu.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  Definition for an interval.
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MeetingRooms {
    private static final String TAG = "MeetingRooms";

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 0) {
            return true;
        }

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 1; i < intervals.length; i++) {
            if (starts[i] <= ends[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean canAttendMeetings0(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        List<Interval> intervalList = new ArrayList<Interval>();
        intervalList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            for (Interval interval : intervalList) {
                if (hasIntersection(interval, intervals[i])) {
                    return false;
                }
            }
            intervalList.add(intervals[i]);
        }
        return true;
    }

    private boolean hasIntersection(Interval interval1, Interval interval2) {
        int d1 = interval1.end - interval1.start;
        int d2 = interval2.end - interval2.start;
        int d12 = Math.max(Math.abs(interval1.start - interval2.end),
                Math.abs(interval2.start - interval1.end));
        if (d1 + d2 > d12) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(7, 10);
        Interval interval2 = new Interval(2, 4);
        Interval[] intervals = {interval1, interval2};
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new MeetingRooms().canAttendMeetings(intervals));
    }
}
