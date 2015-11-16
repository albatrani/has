/*
 * SensorStatus enumeration for the possible sensor states
 */
public enum SensorStatus {

    ENABLED("Enabled"), DISABLED("Disabled");

    private String description;

    private SensorStatus(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }

}
