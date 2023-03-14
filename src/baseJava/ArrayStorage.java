package baseJava;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume == null) {
                break;
            }
            else if (uuid.equals(resume.uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            // проверяем сначала параметр метода с самим полем класса, что бы избежать NPE
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = null;
                break;
            }
        }
        Resume[] newArr = new Resume[10000];
        int count = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                newArr[count] = resume;
                count++;
            }
        }
        storage = newArr;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int size = size();
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                resumes[i] = storage[i];
            }
        }
        return resumes;
    }

    int size() {
        int count = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                count++;
            }
        }
        return count;
    }
}
