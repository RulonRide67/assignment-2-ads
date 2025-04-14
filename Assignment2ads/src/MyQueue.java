public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T element) {
        list.add(element); // добавляем в конец
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        T value = list.get(0);
        list.remove(0); // удаляем из начала
        return value;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return list.get(0);
    }
}
