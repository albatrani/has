public class WindowSensor extends Sensor {

    public WindowSensor(String name) {
        super(name);
        type = SensorType.WINDOW;
    }

    public void enable() {
        status = SensorStatus.ENABLED;
    }

    public void disable() {
        status = SensorStatus.DISABLED;
    }
}
