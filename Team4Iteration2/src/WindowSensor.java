
public class WindowSensor extends Sensor {
public WindowSensor(String name) {
	super(name);
	type = SensorType.WINDOW;
	
}
	public void enable() {
		setStatus(SensorStatus.ENABLED);
	}

	public void disable() {
		setStatus(SensorStatus.DISABLED);
	}
}
