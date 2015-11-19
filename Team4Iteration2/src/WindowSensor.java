/*
 * Concrete implementation of window motion sensor derived from Sensor abstract class
 */
public class WindowSensor extends Sensor {

    public WindowSensor(String name) {
        super(name);
        type = SensorType.WINDOW;
    }

    /*
     * Commands the hardware to enable sensor
     */
    @Override
    public void enable() {
        status = SensorStatus.ENABLED;
        logWindowSensorStatusChange();
    }

    private void logWindowSensorStatusChange() {
        System.out.printf("%s sensor - %s was %s%n", type, getName(), status);
    }

    /*
     * Commands the hardware to disable sensor
     */
    @Override
    public void disable() {
        status = SensorStatus.DISABLED;
        logWindowSensorStatusChange();
    }
}
