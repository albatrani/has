
public class WindowSensor extends Sensor {

	public void enable() {
		setStatus(SensorStatus.ENABLED);
	}

	public void disable() {
		setStatus(SensorStatus.DISABLED);
	}
}
