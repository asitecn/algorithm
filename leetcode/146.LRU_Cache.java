public class LRUCache {

    class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
    
    int size;
    int capacity;
    ListNode dummyHead = null;
    ListNode dummyTail = null;
    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        dummyHead = new ListNode(0, 0);
        dummyTail = new ListNode(0, 0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        map = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        ListNode value = map.get(key);
        if (value == null) {
            return -1;
        }

        // move value to the top
        remove(value);
        insertHead(value);
        return value.val;
    }
    
    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void insertHead(ListNode value) {
        value.prev = dummyHead;
        dummyHead.next.prev = value;
        value.next = dummyHead.next;
        dummyHead.next = value;        
    }
    
    public void set(int key, int value) {
        ListNode node = map.get(key);
        if (node == null) {
            if (map.size() == capacity) {
                // need to insert, purge
                ListNode purged = dummyTail.prev;
                remove(purged);
                map.remove(purged.key);
            }
            node = new ListNode(key, value);
            map.put(key, node);
        } else {
            remove(node);
        }
        node.val = value;
        insertHead(node);
    }
}
