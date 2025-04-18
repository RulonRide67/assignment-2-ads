import com.sun.jdi.ObjectCollectedException;

import java.util.Iterator;

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

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object.equals(elements[i])) {
                return i;
            }else throw new ObjectCollectedException("Object not found");
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("The list is empty");
        for (int i = size; i > -1; i--) {
            if (object.equals(elements[i])) {
                return i;
            }else throw new ObjectCollectedException("Object not found");
        }
        return 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    
    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (object.equals(elements[i])) {
                return true;
            }else return false;
        }
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return null;
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

    @Override
    public void add(int index, T element) {
        if (size == elements.length) {
            capinc(elements);
        }
        for (int i = size; i == index ; i--) {
            elements[i+1] = elements[i];
        }
        elements[index] = element;
    }

    @Override
    public void addFirst(T element) {
        if (size == elements.length) {
            capinc(elements);
        }
        for (int i = size; i > 0; i--) {
            elements[i - 1] = elements[i];
        }
        elements[0] = element;
    }

    @Override
    public void addLast(T element) {
        add(element);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
