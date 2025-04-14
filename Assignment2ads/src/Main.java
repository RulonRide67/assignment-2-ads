public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> mylist = new MyArrayList();

        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
        mylist.add(4);
        mylist.add(5);

        for (int i = 0; i < mylist.size(); i++) {
            System.out.println(mylist.get(i));
        }

        System.out.println(mylist.size());
        System.out.println();
        MyLinkedList<String> linklist = new MyLinkedList<>();

        linklist.add("A");
        linklist.add("B");
        linklist.add("C");
        linklist.add("D");

        System.out.println("2:"+linklist.get(2));
        System.out.println("size before remove " + linklist.size());

        linklist.remove(1);
        System.out.println("1 sfter now: " + linklist.get(1));
        System.out.println("size after remove: " + linklist.size());

        linklist.clear();
        System.out.println("size clear: " + linklist.size());
    }
}