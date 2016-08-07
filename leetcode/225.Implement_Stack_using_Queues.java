class MyStack {
    // You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.

    Queue<Integer> iq = new LinkedList<Integer>();
    Queue<Integer> tq = new LinkedList<Integer>();
    int top = -1;
    
    // Push element x onto stack.
    public void push(int x) {
        iq.offer(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (empty()) {
            return;
        }
        while(iq.size() > 1) {
            top = iq.peek();
            tq.offer(top);
            iq.remove();
        }
        iq = tq;
        tq = new LinkedList<Integer>();
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return (iq.isEmpty());
    }
}
