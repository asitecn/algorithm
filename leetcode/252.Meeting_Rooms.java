// Solution 1
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
    public boolean canAttendMeetings(Interval[] intervals) {

        // Given [[0, 30],[5, 10],[15, 20]],
        // return false.        
        
        Arrays.sort(intervals, new Comparator<Interval>() {
           @Override
           public int compare(Interval v1, Interval v2) {
               if (v1.start < v2.start) {
                   return -1;
               }
               if (v1.start > v2.start) {
                   return 1;
               }
               if (v1.end < v2.end) {
                   return -1;
               }
               if (v1.end > v2.end) {
                   return 1;
               }
               return 0;
           }
        });
        
        Interval lastInterval = null;
        for (int i = 0; i < intervals.length; i++) {
            if (i > 0) {
                if (lastInterval.end > intervals[i].start) {
                    return false;
                }
            }
            lastInterval = intervals[i];
        }
        return true;
    }
}


// Solution 2
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
    public boolean canAttendMeetings(Interval[] intervals) {

        // Given [[0, 30],[5, 10],[15, 20]],
        // return false.        
        
        Arrays.sort(intervals, (a, b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });

        Interval lastInterval = null;
        for (int i = 0; i < intervals.length; i++) {
            if (i > 0) {
                if (lastInterval.end > intervals[i].start) {
                    return false;
                }
            }
            lastInterval = intervals[i];
        }
        return true;
    }
}
