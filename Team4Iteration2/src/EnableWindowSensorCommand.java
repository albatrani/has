public class EnableWindowSensorCommand extends SensorControlCommand {

    public EnableWindowSensorCommand(Sensor sensor) {
        super(sensor);
    }

    @Override
    public boolean execute() {
        sensor.enable();
        return sensor.getStatus() == SensorStatus.ENABLED;
    }

}
