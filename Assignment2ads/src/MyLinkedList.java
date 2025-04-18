import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size = 0;

    @Override
    public void add(T element) {
        MyNode newNode = new MyNode(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        getNode(index).data = item;
    }

    private void checkIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (index == 0) {
            addFirst(element);
        }
        if (index == size) {
            addLast(element);
        }
        MyNode current = getNode(index);
        MyNode newNode = new MyNode(element);

        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;

        size++;
    }

    @Override
    public void addFirst(T element) {
        
    }

    @Override
    public void addLast(T element) {

    }

    @Override
    public void removeFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException("The list is empty");
        }
//        T removedEl = head.data;
        if (head == tail) {
            head = tail = null;
        }else
            head = head.next;
        size--;
    }
    public void remove(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeLast() {
        if (head == null) {
            throw new IndexOutOfBoundsException("The list is empty");
        }
        if (head == tail) {
            head = tail = null;
        }else
            tail = tail.prev;
            tail.next = null;
        size--;

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

//    @Override
//    public boolean exists(Object object) {
//        return false;
//    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyNode current = (index < size / 2) ? head : tail;

        if (index < size / 2) {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    @Override
    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
