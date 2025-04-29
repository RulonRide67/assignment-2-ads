import java.util.Iterator;
import java.util.Stack;

public class BST <K extends Comparable<K>, V> {
    private Node root = null;

    public class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    private int nodeCount = 0;

    public int size() {
        return nodeCount;
    }

    public void put(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            nodeCount++;
        } else {
            Node current = root;
            while (true) {
                if (current.key.compareTo(key) == 0) {
                    current.value = value;
                    return;
                } else if (current.key.compareTo(key) > 0) {
                    if (current.left == null) {
                        current.left = new Node(key, value);
                        nodeCount++;
                        return;
                    } else {
                        current = current.left;
                    }
                } else if (current.key.compareTo(key) < 0) {
                    if (current.right == null) {
                        current.right = new Node(key, value);
                        nodeCount++;
                        return;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }


    public V get(K key) {
        if (root == null) {
            return null;
        }
        Node current = root;
        while (current != null) {
            if (current.key.compareTo(key) == 0) {
                return current.value;
            } else if (current.key.compareTo(key) > 0) {
                current = current.left;
            } else if (current.key.compareTo(key) < 0) {
                current = current.right;
            }
        }
        return null;
    }

    public void delete(K key) {
        Node current = root;
        Node parent = null;
        while (current != null && !current.key.equals(key)) {
            parent = current;
            if (current.key.compareTo(key) > 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) return;

        nodeCount--;

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (parent.left == current) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (parent.left == current) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else {
            Node successorParent = current;
            Node successor = current.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.key = successor.key;
            current.value = successor.value;

            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            }
            else {
                successorParent.right = successor.right;
            }
        }
    }


    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public Iterable<Entry<K, V>> iterator() {
        return new Iterable<Entry<K, V>>() {
            @Override
            public Iterator<Entry<K, V>> iterator() {
                return new Iterator<Entry<K, V>>() {

                    private Stack<Node> stack = new Stack<>();
                    private Node current = root;

                    {pushLeft(current);}

                    private void pushLeft(Node node) {
                        while (node != null) {
                            stack.push(node);
                            node = node.left;
                        }
                    }

                    @Override
                    public boolean hasNext() {
                        return !stack.isEmpty();
                    }

                    @Override
                    public Entry<K, V> next() {
                        Node node = stack.pop();
                        if (node.right != null)
                            pushLeft(node.right);
                        return new Entry<>(node.key, node.value);
                    }
                };
            }
        };
    }
}
