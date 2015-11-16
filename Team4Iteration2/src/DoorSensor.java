public class DoorSensor extends Sensor {

    public DoorSensor(String name) {
        super(name);
        type = SensorType.DOOR;
    }

    public void enable() {
        status = SensorStatus.ENABLED;
    }

    public void disable() {
        status = SensorStatus.DISABLED;
    }
}
