import model.Resume;
import storage.ArrayStorage;
import storage.Storage;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        Resume r2 = new Resume();
        Resume r3 = new Resume();


        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());

        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get r1.uuid: " + ARRAY_STORAGE.get(r3.getUuid()));
        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
