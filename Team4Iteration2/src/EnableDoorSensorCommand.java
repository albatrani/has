public class EnableDoorSensorCommand extends SensorControlCommand {

    public EnableDoorSensorCommand(Sensor sensor) {
        super(sensor);
    }

    @Override
    public boolean execute() {
        sensor.enable();
        return sensor.getStatus() == SensorStatus.ENABLED;
    }

}
