package storage;

import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    public Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int maxIndex = 0;

    public int size() {

        return maxIndex;
    }

    public Resume get(String uuid) {
        int index = getIndexById(uuid);
        if (index == -1) {
            System.out.println("Ничего не нашли для get");
            return null;
        }
        return storage[index];
    }


    public void clear() {
        Arrays.fill(storage, 0, maxIndex, null);
        maxIndex = 0;
    }

    protected abstract int getIndexById(String uuid);
}
