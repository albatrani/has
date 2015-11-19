public class WindowSensor extends Sensor {

    public WindowSensor(String name) {
        super(name);
        type = SensorType.WINDOW;
    }

    public void enable() {
        status = SensorStatus.ENABLED;
        logWindowSensorStatusChange();
    }

    private void logWindowSensorStatusChange() {
        System.out.printf("%s sensor - %s was %s%n", type, getName(), status);
    }

    public void disable() {
        status = SensorStatus.DISABLED;
        logWindowSensorStatusChange();
    }
}
