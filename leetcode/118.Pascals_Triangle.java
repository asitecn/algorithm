public class Solution {
    public List<List<Integer>> generate(int numRows) {
        
    //  [1],
    //  [1,1],
    //  [1,2,1],
    //  [1,3,3,1],
    //  [1,4,6,4,1]        
 
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        if (numRows == 0) {
            return results;
        }
        
        {
            List<Integer> firstRow = new LinkedList<Integer>();
            firstRow.add(1);
            results.add(firstRow);
        }
        
        for(int i = 1; i < numRows; i++) {
            List<Integer> lastRow = results.get(i-1);
            List<Integer> thisRow = new LinkedList<Integer>();
            thisRow.add(1);
            for(int j = 1; j < lastRow.size(); j++) {
                thisRow.add(lastRow.get(j) + lastRow.get(j-1));
            }
            thisRow.add(1);
            results.add(thisRow);
        }
        return results;
    }
}
