public class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for(int i = 1; i < n; i++) {
            int v2 = list.get(i2) * 2;
            int v3 = list.get(i3) * 3;
            int v5 = list.get(i5) * 5;
            int min = Math.min(Math.min(v2, v3), v5);
            list.add(min);
            if (v2 == min) {
                i2++;
            }
            if (v3 == min) {
                i3++;
            }
            if (v5 == min) {
                i5++;
            }
        }
        return list.get(list.size() - 1);
    }
}
