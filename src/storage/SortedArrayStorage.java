package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveByIndex(Resume r, int index) {

        int insrtIdx = -index - 1;
        System.arraycopy(storage, insrtIdx, storage, insrtIdx + 1, size - insrtIdx);
        storage[insrtIdx] = r;
        size++;
    }

    @Override
    public void deleteByIndex(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    @Override
    protected int getIndexById(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
