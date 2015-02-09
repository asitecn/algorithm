class ListNode<K, V> {
    ListNode<K,V> next;
    K key;
    V value;
    public ListNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class HashTable<K, V> {

    int size = 0;
    int capacity = 256;
    ListNode<K, V>[] arr;
    
    private int hash(K key) {
        return key.hashCode();
    }

    public HashTable() {
        arr = new ListNode[capacity];
    }

    public void put(K key, V value) {
        int id = hash(key) % capacity;
//        System.out.println(id);
        if (arr[id] == null) {
            arr[id] = new ListNode<K, V>(null, null);
        }
        ListNode<K, V> node = arr[id].next;
        while(node != null) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        node = new ListNode<>(key, value);
        node.next = arr[id].next;
        arr[id].next = node;
        size++;
    }

    public V get(K key) {
        int id = hash(key) % capacity;
        ListNode<K, V> node = arr[id];
        if (node == null) {
            return null;
        }
        node = arr[id].next;
        while(node != null) {
            if (key.equals(node.key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void remove(K key) {
        int id = hash(key) % capacity;
        ListNode<K, V> node = arr[id];
        if (node == null) {
            return;
        }
        ListNode<K, V> prev = node;
        node = node.next;
        while(node != null) {
            if (key.equals(node.key)) {
                break;
            }
            prev = node;
            node = node.next;
        }
        if (node != null) {
            prev.next = node.next;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public static void main(String args[]) {
        HashTable<Integer, Integer> ht = new HashTable<>();
        ht.put(1, 10);
        ht.put(1, 15);
        ht.put(257, 20);
        ht.remove(257);
        System.out.println(ht.get(1) + "\tsize=" + ht.size());
        ht.put(257, 25);
        System.out.println(ht.get(257) + "\tsize=" + ht.size());
    }

}
