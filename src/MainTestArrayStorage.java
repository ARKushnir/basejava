import model.Resume;
import storage.SortedArrayStorage;
import storage.Storage;

import java.util.Arrays;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.setUuid("uuid2");
        Resume r2 = new Resume();
        r2.setUuid("uuid3");


        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);


        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());
        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        //ARRAY_STORAGE.delete(r1.uuid);
        //printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
        //ARRAY_STORAGE.update(r4);
        printAll();
        System.out.println("Index of r2 " + Arrays.binarySearch(ARRAY_STORAGE.getAll(), 0, ARRAY_STORAGE.size(), r2));

    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
