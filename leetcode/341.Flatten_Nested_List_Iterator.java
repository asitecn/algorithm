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
public class NestedIterator implements Iterator<Integer> {

    Stack<Iterator<NestedInteger>> stack;
    Integer next;

    public NestedIterator(List<NestedInteger> nestedList) {
        // Given the list [[1,1],2,[1,1]],
        // [1, [4, [6]]]
        next = null;
        stack = new Stack<>();
        stack.push(nestedList.iterator());
        fetchNext();
    }
    
    public void fetchNext() {
        while(!stack.isEmpty()) {
            Iterator<NestedInteger> it = stack.peek();
            if (!it.hasNext()) {
                stack.pop();
                continue;
            }
            NestedInteger val = it.next();
            if (val.isInteger()) {
                next = val.getInteger();
                break;
            } else {
                List<NestedInteger> list = val.getList();
                if (list.size() == 0) {
                    continue;
                }
                it = list.iterator();
                stack.push(it);
            }
        }
    }

    @Override
    public Integer next() {
        Integer val = next;
        fetchNext();
        return val;
    }

    @Override
    public boolean hasNext() {
        return (!stack.isEmpty());
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
