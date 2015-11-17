public class DisableWindowSensorCommand extends SensorControlCommand {

    protected DisableWindowSensorCommand(Sensor sensor) {
        super(sensor);
    }

    @Override
    public boolean execute() {
        sensor.disable();
        return sensor.getStatus() == SensorStatus.DISABLED;
    }

}
