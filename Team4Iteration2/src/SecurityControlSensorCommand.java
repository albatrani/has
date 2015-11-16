
public abstract class SecurityControlSensorCommand implements ICommand {

	protected Sensor sensor;

    protected SecurityControlSensorCommand(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SecurityControlSensorCommand)) {
            return false;
        }

        SecurityControlSensorCommand other = (SecurityControlSensorCommand) obj;
        return this.sensor.getName().equals(other.sensor.getName());
    }

    @Override
    public int hashCode() {
        return sensor.getName().hashCode();
    }

    public Sensor getSensor() {
        return sensor;
    }
}
