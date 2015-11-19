/*
 * Command class to enable window sensors implemented using the command pattern
 */
public class EnableWindowSensorCommand extends SensorControlCommand {

    public EnableWindowSensorCommand(Sensor sensor) {
        super(sensor);
    }

    /*
     * Performs the enabling of the window sensor
     */
    @Override
    public boolean execute() {
        sensor.enable();
        return sensor.getStatus() == SensorStatus.ENABLED;
    }

    @Override
    public String toString() {
        return String.format("%s, Action required: %s", sensor.toString(),
                SensorStatus.ENABLED.toString());
    }
}
