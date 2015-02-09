 import java.util.*;
 class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }

public class MaxPoints {

    public void increment(Map<Double, Integer> map, double key) {
        if (map.get(key) == null) {
            map.put(key, 1);
        } else {
            map.put(key, map.get(key)+1);
        }
    }

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int max = 1;
        for(int i = 0; i < points.length-1; i++) {
            // key = slot, value = occurrences
            Map<Double, Integer> map = new HashMap<>();
            int samePoints = 1;
            int localMax = 0;
            for(int j = i+1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoints++;
                } else if (points[i].x == points[j].x) {
                    increment(map, Double.MIN_VALUE);
                } else {
                    double slope = (points[i].y - points[j].y) * 1.0 / (points[i].x - points[j].x);
                    increment(map, slope);
                }
            }
            for (Map.Entry<Double, Integer> me : map.entrySet()) {
                System.out.println(me.getKey());
                localMax = Math.max(localMax, me.getValue());
            }
            localMax += samePoints;
            max = Math.max(max, localMax);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxPoints mp = new MaxPoints();
        Point[] points = new Point[] {
            new Point(2, 3),
            new Point(3, 3),
            new Point(-5, 3)
        }; 
        int result = mp.maxPoints(points);
        System.out.println(result);
    }
}
