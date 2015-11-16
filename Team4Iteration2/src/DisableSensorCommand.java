public class DisableSensorCommand extends SensorControlCommand {

    protected DisableSensorCommand(Sensor sensor) {
        super(sensor);
    }

    @Override
    public boolean execute() {
        sensor.disable();
        return sensor.getStatus() == SensorStatus.DISABLED;
    }

}
