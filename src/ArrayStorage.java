import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];

    private int maxIndex = 0;

    public void clear() {
            Arrays.fill(storage, null);
        maxIndex = 0;
    }

    public void save(Resume r) {
        int index = getIndexById(r.getUuid());
        if (index >= 0) {
            System.out.println("Нашли дублирующий элемент");

        } else if (maxIndex < storage.length) {
            storage[maxIndex++] = r; //добавляем новый элемент
            System.out.println("Resume добавлено в ячейку " + maxIndex);
        } else {
            System.out.println("Вышли за пределы массива");
        }
    }

    public Resume get(String uuid) {
        int index = getIndexById(uuid);
        if (index == -1) {
            System.out.println("Ничего не нашли для get");
            return null;
        }
        return storage[index];
    }


    public void delete(String uuid) {
        int indexDel = getIndexById(uuid);
        if (indexDel == -1) {
            System.out.println("Ничего не нашли для delete");
            return;
        }

        for (int i = indexDel; i < maxIndex - 1; i++) {
            storage[i] = storage[maxIndex - 1];
            storage[maxIndex] = null;
            maxIndex--;
        }
    }

    public void update(Resume r) {

        int i = getIndexById(r.getUuid());
        if (i == -1) {
            System.out.println("Ничего не нашли для update");
        } else {
            storage[i] = r;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, maxIndex);
    }

    int size() {

        return maxIndex;
    }

    private int getIndexById(String uuid) {
        for (int i = 0; i < maxIndex; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
