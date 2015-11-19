/*
 * Command class to disable window sensors implemented using the command pattern
 */
public class DisableWindowSensorCommand extends SensorControlCommand {

    protected DisableWindowSensorCommand(Sensor sensor) {
        super(sensor);
    }

    /*
     * Performs the disabling of the window sensor
     */
    @Override
    public boolean execute() {
        sensor.disable();
        return sensor.getStatus() == SensorStatus.DISABLED;
    }

    @Override
    public String toString() {
        return String.format("%s, Action required: %s", sensor.toString(),
                SensorStatus.DISABLED.toString());
    }
}
