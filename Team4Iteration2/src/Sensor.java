/*
 * Base class to define motion sensor which can be enabled or disabled.
 */
public abstract class Sensor {

    protected SensorStatus status;
    protected SensorType type;
    private String name;

    protected Sensor(String name) {
        this.name = name;
        status = SensorStatus.DISABLED;

    }

    /*
     * Has to be overridden to perform enabling of the sensor
     */
    public abstract void enable();

    /*
     * Has to be overridden to perform disabling of the sensor
     */
    public abstract void disable();

    /*
     * Gets current sensor status
     */
    public SensorStatus getStatus() {
        return status;
    }

    public SensorType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s Sensor: %s, Current Status: %s", type, name, status);
    }
}
