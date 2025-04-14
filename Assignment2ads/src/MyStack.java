public class MyStack<T> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void push(T element) {
        list.add(element);
    }

   public T pop() {
       if (isEmpty())
           throw new RuntimeException("Stack is empty");
       T removedEl = list.get(list.size() - 1)
       list.remove(list.size() - 1)
       return removedEL;
   }

    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}

