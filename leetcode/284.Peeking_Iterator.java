// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iter;
    Integer next = null;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iter = iterator;
	    fetchNext();
	}

    public void fetchNext() {
        if (iter.hasNext()) {
            this.next = iter.next();
        } else {
            this.next = null;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer temp = next;
	    fetchNext();
	    return temp;
	}

	@Override
	public boolean hasNext() {
	    return (next != null || iter.hasNext());
	}
}
