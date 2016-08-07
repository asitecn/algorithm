/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for(NestedInteger nested : nestedList) {
            sum += (nested.isInteger() ? depth*nested.getInteger() : depthSum(nested.getList(), depth + 1));
        }
        return sum;
    }

    /*
        Example 1:
        Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
    */
    
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }
}
