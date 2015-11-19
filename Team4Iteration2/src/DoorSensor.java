public class DoorSensor extends Sensor {

    public DoorSensor(String name) {
        super(name);
        type = SensorType.DOOR;
    }

    public void enable() {
        status = SensorStatus.ENABLED;
        logDoorSensorStatusChange();
    }

    private void logDoorSensorStatusChange() {
        System.out.printf("%s sensor - %s was %s%n", type, getName(), status);
    }

    public void disable() {
        status = SensorStatus.DISABLED;
        logDoorSensorStatusChange();
    }
}
