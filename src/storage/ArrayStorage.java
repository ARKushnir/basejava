package storage;

import model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveByIndex(Resume r, int index) {
        storage[size] = r;
    }

    public void deleteByIndex(int index) {
        storage[index] = storage[size - 1];
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    protected int getIndexById(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
