package model;

/**
 * Initial resume class
 */
public class Resume implements Comparable {

    private String name;
    // Unique identifier
    private String uuid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        return uuid + " " + name;
    }


    @Override
    public int compareTo(Object o) {
        Resume r = (Resume) o;
        return uuid.compareTo(r.getUuid());
    }
}
