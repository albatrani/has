/*
 * Concrete implementation of door motion sensor derived from Sensor abstract class
 */
public class DoorSensor extends Sensor {

    public DoorSensor(String name) {
        super(name);
        type = SensorType.DOOR;
    }

    /*
     * Commands the hardware to enable sensor
     */
    @Override
    public void enable() {
        status = SensorStatus.ENABLED;
        logDoorSensorStatusChange();
    }

    private void logDoorSensorStatusChange() {
        System.out.printf("%s sensor - %s was %s%n", type, getName(), status);
    }

    /*
     * Commands the hardware to disable sensor
     */
    @Override
    public void disable() {
        status = SensorStatus.DISABLED;
        logDoorSensorStatusChange();
    }
}
