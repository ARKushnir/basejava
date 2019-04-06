package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static storage.AbstractArrayStorage.STORAGE_LIMIT;

public abstract class AbstractArrayStorageTest {

    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME1 = new Resume(UUID_1);
    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME2 = new Resume(UUID_2);
    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME3 = new Resume(UUID_3);
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME4 = new Resume(UUID_4);
    private Storage storage;

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME1);
        storage.save(RESUME2);
        storage.save(RESUME3);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_1);
        storage.update(newResume);
        Assert.assertTrue(newResume == storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(RESUME4);
    }

    @Test(expected = NullPointerException.class)
    public void updateToNull() {
        storage.update(null);
    }

    @Test
    public void getAll() {
        Resume[] expectedArray = {RESUME1, RESUME2, RESUME3};
        Resume[] array = storage.getAll();
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void save() {
        storage.save(new Resume(UUID_4));
        assertSize(4);
        Assert.assertEquals(RESUME4, storage.get(UUID_4));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME1);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = 3; i < STORAGE_LIMIT; i++) {
                String uuid = "uuid" + (i + 1);
                storage.save(new Resume(uuid));
            }
        } catch (StorageException e) {
            Assert.fail("Array is overflowed");
        }
        storage.save(new Resume("uuid10001"));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        assertSize(3);
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("Not exist");
    }

    @Test
    public void get() {
        storage.get(UUID_1);
        storage.get(UUID_2);
        storage.get(UUID_3);
        Assert.assertEquals(RESUME1, storage.get(UUID_1));
        Assert.assertEquals(RESUME2, storage.get(UUID_2));
        Assert.assertEquals(RESUME3, storage.get(UUID_3));

    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(UUID_4);
    }

    private void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }

}