class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(i2, i1);
            }
        });
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            if (maxHeap.isEmpty()) {
                maxHeap.add(num);
            } else {
                if (num <= maxHeap.peek()) {
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            }
        } else if (maxHeap.size() > minHeap.size()) {
            if (num > maxHeap.peek()) {
                minHeap.add(num);
            } else {
                minHeap.add(maxHeap.remove());
                maxHeap.add(num);
            }
        } else {
            if (num < minHeap.peek()) {
                maxHeap.add(num);
            } else {
                maxHeap.add(minHeap.remove());
                minHeap.add(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.size() == 0 ? 0.0 : (minHeap.peek() + maxHeap.peek()) / 2.0);
        }
        return (double)(minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek());
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
