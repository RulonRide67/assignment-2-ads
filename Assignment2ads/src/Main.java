import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10_000; i++) {
            int id = random.nextInt(1000);
            String name = "Name" + random.nextInt(100);
            MyTestingClass key = new MyTestingClass(id, name);
            Student value = new Student("Student" + i, 18 + random.nextInt(10));
            table.put(key, value);
        }

        printBucketDistribution(table);
    }

    private static void printBucketDistribution(MyHashTable<MyTestingClass, Student> table) {
        int[] bucketSizes = table.getBucketSizes();
        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i] + " elements");
        }
    }
}
