public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + "=" + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11; // default number of chains
    private int size;

    public MyHashTable() {
        this(11);
    }

    public MyHashTable(int M) {
        this.M = M;
        this.chainArray = (HashNode<K, V>[]) new HashNode[M];
        this.size = 0;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = hash(key);
        HashNode<K, V> current = chainArray[index];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value; // Update existing value
                return;
            }
            current = current.next;
        }

        // Add new node at the beginning of the chain
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = hash(key);
        HashNode<K, V> current = chainArray[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        HashNode<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    chainArray[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }

        return null;
    }

    public boolean contains(V value) {
        return getKey(value) != null;
    }

    public K getKey(V value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                if (value.equals(current.value)) {
                    return current.key;
                }
                current = current.next;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append("[").append(i).append("]: ");
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                sb.append(current);
                if (current.next != null) {
                    sb.append(" -> ");
                }
                current = current.next;
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}