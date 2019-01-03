package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void update(Resume r) {
        int index = getIndexById(r.getUuid());
        if (index < 0) {
            return;
        }
        storage[index] = r;

    }

    @Override
    public void save(Resume r) {
        int index = getIndexById(r.getUuid());
        if (index >= 0) {
            return;
        }
        index = Math.abs(index) - 1;
        for (int i = index; i < maxIndex; i++) {
            storage[maxIndex - i] = storage[maxIndex - 1 - i];
        }
        storage[index] = r;
        maxIndex++;

    }

    @Override
    public void delete(String uuid) {
        int index = getIndexById(uuid);
        if (index < 0) {
            return;
        }
        storage[index] = null;
        for (int i = index; i < maxIndex - 1; i++) {
            storage[i] = storage[i + 1];
        }
        maxIndex--;

    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, maxIndex);
    }

    @Override
    protected int getIndexById(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, maxIndex, searchKey);
    }
}
//