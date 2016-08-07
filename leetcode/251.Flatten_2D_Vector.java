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
