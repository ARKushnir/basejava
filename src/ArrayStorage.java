/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    //ArrayList<Resume> myResumeArrayList = new ArrayList<Resume>();
    private Resume[] storage = new Resume[5];

    private int maxIndex = 0; // индекс, следующий за последним заполненным значением

    public void clear() {
        for (int i = 0; i < maxIndex; i++) {
            storage[i] = null;
        }
        maxIndex = 0;
    }

    public void save(Resume r) {
        if (maxIndex < storage.length) {
            storage[maxIndex++] = r;
            System.out.println("Resume добавлено в ячейку " + maxIndex);
            //i++;
        }

    }

    public Resume get(String uuid) {
        for (int i = 0; i < maxIndex; i++) {
            Resume r = storage[i];
            if (uuid.equals(r.getUuid())) {
                return r;
            }
        }
        return null;
    }


    public void delete(String uuid) {
        int inxDel = -1; // индекс элемента которого мы хотим удалить
        for (int i = 0; i < maxIndex; i++) {
            Resume r = storage[i];
            if (uuid.equals(r.getUuid())) {
                inxDel = i;
                break;
            }
        }
        if (inxDel == -1) {
            return;
        }

        for (int i = inxDel; i < maxIndex - 1; i++) {
            storage[i] = storage[i + 1];
        }
        maxIndex--;
        storage[maxIndex] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        //return Arrays.copyOfRange(storage, 0, maxIndex);
        Resume[] dest = new Resume[maxIndex];
        for (int i = 0; i < maxIndex; i++) {
            dest[i] = storage[i];

        }
        return dest;
    }


    int size() {

        return maxIndex;
    }

    //return 0;

}
