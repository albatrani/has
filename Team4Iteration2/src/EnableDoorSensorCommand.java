/*
 * Command class to enable door sensors implemented using the command pattern
 */
public class EnableDoorSensorCommand extends SensorControlCommand {

    public EnableDoorSensorCommand(Sensor sensor) {
        super(sensor);
    }

    /*
     * Performs the enabling of the door sensor
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
