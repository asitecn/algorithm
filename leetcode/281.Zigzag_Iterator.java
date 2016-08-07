public class ZigzagIterator {

/*
[1,2,3]
[4,5,6,7]
[8,9]

It should return [1,4,8,2,5,9,3,6,7].
*/

    Queue<Iterator<Integer>> queue;
    Integer value = null;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (v1.size() > 0) {
            queue.offer(v1.iterator());
        }
        if (v2.size() > 0) {
            queue.offer(v2.iterator());
        }
        if (queue.size() > 0) {
            fetchNext();
        }
    }

    private void fetchNext() {
        if (queue.size() == 0) {
            return;
        }
        Iterator<Integer> it = queue.poll();
        if (it.hasNext()) {
            value = it.next();
            if (it.hasNext()) {
                queue.offer(it);
            }
        }
    }

    public int next() {
        Integer next = value;
        value = null;
        fetchNext();
        return next;
    }

    public boolean hasNext() {
        //System.out.println(value);
        return (value != null);
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
