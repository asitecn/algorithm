import java.util.*;
class Interval {
    int s;
    int e;
    public Interval(int s, int e) {
        this.s = s;
        this.e = e;
    }
    public void print() {
        System.out.println(s + "\t" + e);
    }
}

public class LargestIntersect {

    int max = Integer.MIN_VALUE;
    Interval largest = null;

    public boolean overlap(Interval a, Interval b) {
        return !(a.e < b.s || b.e < a.s);
    }

    public Interval findLargestLinear(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if (a.s == b.s && a.e == b.e) {
                    return 0;
                }
                if (a.s == b.s) {
                    return (a.e < b.e ? -1 : 1);
                }
                return (a.s < b.s ? -1 : 1);
            }
        });

      for(int i = 0; i < intervals.length; i++) {
            int total = 0;
            Interval candidate = intervals[i];
            //candidate.print();
            for(int j = 0; j < intervals.length; j++) {
                //intervals[j].print();
                if (i != j && overlap(candidate, intervals[j])) {
                    total++;
                }
            }
            //System.out.println("-----------------");
            if (total > max) {
                max = total;
                largest = candidate;
            }
        }
        return largest;
    }


    public Interval findLargestBinary(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if (a.s == b.s && a.e == b.e) {
                    return 0;
                }
                if (a.s == b.s) {
                    return (a.e < b.e ? -1 : 1);
                }
                return (a.s < b.s ? -1 : 1);
            }
        });

      for(int i = 0; i < intervals.length; i++) {
            int start = i+1;
            int end = intervals.length-1;
            int total = 0;
            Interval candidate = intervals[i];
            while(start <= end) {
                int mid = start + (end - start) / 2;
                if (overlap(candidate, intervals[mid])) {
                    total += mid - start + 1;
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
            if (total > max) {
                max = total;
                largest = candidate;
            }
        }
        return largest;
    }




    public static void main(String args[]) {
        
        Interval[] intervals = new Interval[6];
        intervals[0] = new Interval(2, 3);
        intervals[1] = new Interval(4, 5);
        intervals[2] = new Interval(3, 6);
        intervals[3] = new Interval(1, 8);
        intervals[4] = new Interval(6, 9);
        intervals[5] = new Interval(9, 10);
        LargestIntersect li = new LargestIntersect();
        Interval interval = li.findLargestBinary(intervals);
        System.out.println(interval.s + "\t" + interval.e + "\t" + li.max);
    }

}
