public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;
    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }
    public void add(T element) {
        if (size == elements.length) {
            capinc(elements);
        }
        elements[size++] = element;
    }
    public void capinc(Object[] element) {
        Object[] newMyArraylist = new Object[element.length * 2];
        for (int i = 0; i < element.length; i++) {
            newMyArraylist[i] = element[i];
        }
        elements = newMyArraylist;
    }
    private void checkIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public void set(int index, T newElement) {
        checkIndex(index);
        elements[index] = newElement;
    }
}