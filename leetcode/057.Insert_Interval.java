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
    
    // Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9]. 
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> res = new ArrayList<>();
        boolean merged = false;
        for(Interval interval : intervals) {
            if (merged) {
                res.add(interval);
                continue;
            }
            if (newInterval.end < interval.start) {
                res.add(newInterval);
                res.add(interval);
                merged = true;
            } else if (newInterval.start > interval.end) {
                res.add(interval);
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        if (!merged) {
            res.add(newInterval);
        }
        return res;
    }
}
