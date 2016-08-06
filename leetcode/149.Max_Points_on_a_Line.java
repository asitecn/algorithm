/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    
    public int maxPoints(Point[] points) {
        if (points.length <= 1) {
            return points.length;
        }
        
        int globalMax = 0;
        for(int i = 0; i < points.length - 1; i++) {
            int same = 0;
            Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
            int max = 0;

            for(int j = i+1; j < points.length; j++) {
                Point pj = points[j];
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if (x == 0 && y == 0) {
                    same++;
                    continue;
                } 

                int gcd = generateGCD(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                } else {
                    if (x == 0) {
                        y = 0;
                    } else if (y == 0) {
                        x = 0;
                    }
                }

                if (!map.containsKey(x)) {
                    map.put(x, new HashMap<Integer, Integer>());
                }
                Map<Integer, Integer> submap = map.get(x);
                if (!submap.containsKey(y)) {
                    submap.put(y, 0);
                }
                submap.put(y, submap.get(y) + 1);

                if (submap.get(y) > max) { 
                    max = submap.get(y);
                }
            }
            if (1 + max + same > globalMax) {
                globalMax = max + same + 1;
            }
        }    
        return globalMax;
    }
        
        public int generateGCD(int a, int b) {
            if (b == 0) {
                return 0;
            }
            return (a % b == 0 ? b : generateGCD(b, a%b));
        }
}
