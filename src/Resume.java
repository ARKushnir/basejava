/**
 * Initial resume class
 */
public class Resume {

    private String name;
    // Unique identifier
    public String uuid;

    public void setName(String name) {
        this.name = name;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }



    @Override
    public String toString() {

        return uuid;
    }

}
