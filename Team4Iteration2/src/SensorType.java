/*
 * SensorType enumeration for the possible sensor types
 */
public enum SensorType {

    WINDOW("Window"), DOOR("Door");

    private String description;

    private SensorType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }

}
