public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap = new MyArrayList<>();

    public void insert(T element) {
        heap.add(element);
        siftUp(heap.size() - 1);
    }

    public T extractMin() {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
        T min = heap.get(0);
        T last = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(0, last);
            siftDown(0);
        }
        return min;
    }

    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i).compareTo(heap.get(parent)) < 0) {
                swap(i, parent);
                i = parent;
            } else break;
        }
    }

    private void siftDown(int i) {
        int size = heap.size();
        while (2 * i + 1 < size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int min = left;

            if (right < size && heap.get(right).compareTo(heap.get(left)) < 0) {
                min = right;
            }

            if (heap.get(i).compareTo(heap.get(min)) > 0) {
                swap(i, min);
                i = min;
            } else break;
        }
    }

    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }

    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Heap is empty");
        return heap.get(0);
    }
}
