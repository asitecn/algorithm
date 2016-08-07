// Solution 1
public class Vector2D {

    Iterator<List<Integer>> iter1 = null;
    Iterator<Integer> iter2 = null;

    public Vector2D(List<List<Integer>> vec2d) {
        if (vec2d != null && vec2d.size() > 0) {
            iter1 = vec2d.iterator();
            iter2 = iter1.next().iterator();
            getNextValidRow();
        }
    }
    
    public void getNextValidRow() {
        while(!iter2.hasNext() && iter1.hasNext()) {
            iter2 = iter1.next().iterator();
        }
    }

    public int next() {
        int val = iter2.next();
        getNextValidRow();
        return val;
    }

    public boolean hasNext() {
        return iter2 != null && iter2.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */


// Solution 2
public class Vector2D implements Iterator<Integer> {

    Iterator<List<Integer>> outer;
    Iterator<Integer> inner;
    Integer next = null;

    public Vector2D(List<List<Integer>> vec2d) {
        inner = null;
        outer = vec2d.iterator();
        fetchNext();
    }
    
    public void fetchNext() {
        next = null;
        if (inner != null && inner.hasNext()) {
            next = inner.next();
        } else {
            while(outer.hasNext()) {
                inner = outer.next().iterator();
                if (inner.hasNext()) {
                    next = inner.next();
                    break;
                }
            }
        }
    }

    @Override
    public Integer next() {
        Integer temp = next;
        fetchNext();
        return temp;
    }

    @Override
    public boolean hasNext() {
        return (next != null);
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
