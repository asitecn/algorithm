public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int costs = 0;
        int gases = 0;
        int accumulated = 0;
        int nextStation = 0;
        for(int i = 0; i < cost.length; i++) {
            costs += cost[i];
            gases += gas[i];
            accumulated += (gas[i] - cost[i]);
            if (accumulated < 0) {
                accumulated = 0;
                nextStation = (i == cost.length - 1 ? 0 : i + 1);
            }
        }
        return (gases < costs ? -1 : nextStation);
    }
}
