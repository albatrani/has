/*
 * Command class to disable door sensors implemented using the command pattern
 */
public class DisableDoorSensorCommand extends SensorControlCommand {

    protected DisableDoorSensorCommand(Sensor sensor) {
        super(sensor);
    }

    /*
     * Performs the disabling of the door sensor
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
