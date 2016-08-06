public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastRow = new LinkedList<Integer>();
        lastRow.add(1);
        if (rowIndex == 0) {
            return lastRow;
        }

        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> thisRow = new LinkedList<Integer>();
            thisRow.add(1);
            for(int j = 1; j < lastRow.size(); j++) {
                thisRow.add(lastRow.get(j) + lastRow.get(j-1));
            }
            thisRow.add(1);
            lastRow = thisRow;
        }
        return lastRow;
    }
}
