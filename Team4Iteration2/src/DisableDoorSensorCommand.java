public class DisableDoorSensorCommand extends SensorControlCommand {

    protected DisableDoorSensorCommand(Sensor sensor) {
        super(sensor);
    }

    @Override
    public boolean execute() {
        sensor.disable();
        return sensor.getStatus() == SensorStatus.DISABLED;
    }

}
