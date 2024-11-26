
# LRU (Least Recently Used) Cache Implementation in Java

## Code Snippet

```java
import java.util.*;

class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList<>();
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node<K, V> node = map.get(key);
        dll.moveToFront(node);
        return node.value;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.value = value;
            dll.moveToFront(node);
        } else {
            if (map.size() == capacity) {
                Node<K, V> lru = dll.removeLast();
                map.remove(lru.key);
            }
            Node<K, V> newNode = new Node<>(key, value);
            dll.addFirst(newNode);
            map.put(key, newNode);
        }
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DoublyLinkedList<K, V> {
        private Node<K, V> head;
        private Node<K, V> tail;

        DoublyLinkedList() {
            head = new Node<>(null, null);
            tail = new Node<>(null, null);
            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        void moveToFront(Node<K, V> node) {
            remove(node);
            addFirst(node);
        }

        Node<K, V> removeLast() {
            if (tail.prev == head) {
                return null;
            }
            Node<K, V> lastNode = tail.prev;
            remove(lastNode);
            return lastNode;
        }

        private void remove(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}
```

## Explanation

1. **Data Structures Used**:
   - **HashMap (K, Node)**: Maps keys to their corresponding nodes in the Doubly Linked List for O(1) access.
   - **Doubly Linked List**: Maintains the order of usage of keys. The most recently used node is at the front, and the least recently used is at the end.

2. **Operations**:
   - **get(K key)**:
     - Checks if the key exists in the map. If it does, it moves the corresponding node to the front of the list (most recently used).
   - **put(K key, V value)**:
     - If the key already exists, its value is updated, and the node is moved to the front.
     - If the key doesn’t exist and the cache is full, the least recently used node is removed from both the list and the map.

3. **Time Complexity**:
   - **Insertion**: O(1)
   - **Deletion**: O(1)
   - **Lookup**: O(1)

4. **Trade-Offs**:
   - **Memory Overhead**: Uses extra space for the Doubly Linked List and HashMap.
   - **Complexity vs. Simplicity**: While the implementation is efficient, maintaining two data structures increases the complexity of the codebase.

5. **Applications**:
   - **Web Browsers**: Storing the most recently visited pages.
   - **Operating Systems**: Page replacement algorithms in virtual memory.
   - **Database Caching**: Efficiently managing frequently queried data.

## Diagram

![LRU Cache Diagram](diagram_placeholder.png)

## Advantages

- Fast access and update operations.
- Predictable and consistent performance.

## Disadvantages

- Increased memory usage due to the combination of two data structures.
- Slightly more complex to implement compared to simpler cache strategies.

