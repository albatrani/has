
public class DoorSensor extends Sensor {

	public void enable() {
		setStatus(SensorStatus.ENABLED);
	}

	public void disable() {
		setStatus(SensorStatus.DISABLED);

	}

}
