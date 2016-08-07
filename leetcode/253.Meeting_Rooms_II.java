// Solution 1, 6ms
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for(int i = 0; i < starts.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int s = 0;
        int e = 0;
        int count = 0;
        int max = 0;
        while(s < intervals.length) {
            if (starts[s] == ends[e]) {
                s++;
                e++;
            } else if (starts[s] < ends[e]) {
                s++;
                count++;
                max = Math.max(count, max);
            } else {
                e++;
                count--;
            }
        }
        return max;
    }
}

// Solution 2, 95ms
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        /*
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for(int i = 0; i < starts.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int s = 0;
        int e = 0;
        int count = 0;
        int max = 0;
        while(s < intervals.length) {
            if (starts[s] == ends[e]) {
                s++;
                e++;
            } else if (starts[s] < ends[e]) {
                s++;
                count++;
                max = Math.max(count, max);
            } else {
                e++;
                count--;
            }
        }
        return max;
        */
        
        
        Arrays.sort(intervals, (a, b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });
        
        Queue<Interval> q = new PriorityQueue<Interval>((a, b) -> {
                if (a.end == b.end) {
                    return a.start - b.start;
                }
                return a.end - b.end;
            });
        
        int max = 0;
        for(int i = 0; i < intervals.length; i++) {
            Interval interval = intervals[i];
            while(!q.isEmpty() && q.peek().end <= interval.start) {
                q.poll();
            }
            q.offer(interval);
            max = Math.max(max, q.size());
        }
        
        return max;
    }
}
