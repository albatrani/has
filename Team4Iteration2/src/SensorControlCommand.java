
public abstract class SensorControlCommand implements ICommand {

	protected Sensor sensor;

    protected SensorControlCommand(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SensorControlCommand)) {
            return false;
        }

        SensorControlCommand other = (SensorControlCommand) obj;
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
