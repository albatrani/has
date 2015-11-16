public class EnableSensorCommand extends SensorControlCommand {

    public EnableSensorCommand(Sensor sensor) {
        super(sensor);
    }

    @Override
    public boolean execute() {
        sensor.enable();
        return sensor.getStatus() == SensorStatus.ENABLED;
    }

}
