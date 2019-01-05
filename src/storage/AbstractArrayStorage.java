package storage;

import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndexById(uuid);
        if (index < 0) {
            System.out.println("Ничего не нашли для get");
            return null;
        } else {
            return storage[index];
        }
    }


    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndexById(r.getUuid());
        if (index < 0) {
            System.out.println("Ничего не нашли для update");
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        int index = getIndexById(r.getUuid());
        if (size == STORAGE_LIMIT) {
            System.out.println("Хранилище заполнено");
        } else if (index >= 0) {
            System.out.println("Нашли дублирующий элемент");
        } else {
            saveByIndex(r, index);
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndexById(uuid);
        if (index < 0) {
            System.out.println("Ничего не нашли для delete");
        } else {
            deleteByIndex(index);
            storage[size - 1] = null;
            size--;
        }
    }


    protected abstract void saveByIndex(Resume r, int index);

    protected abstract void deleteByIndex(int index);

    protected abstract int getIndexById(String uuid);
}
