/*
 * SecurityControlTransactionType enumeration for the possible Security Control
 * Transaction types
 */
public enum SecurityControlTransactionType {

    SECURE_FOR_NIGHT("Secure For Night"),
    GOOD_MORNING("Good Morning"),
    CUSTOM_SENSOR_LOCK_SELECTION("Custom Window/Door Sensors and/or Door Lock Selections");

    private String description;

    private SecurityControlTransactionType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }

}
