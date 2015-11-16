
public class DoorSensor extends Sensor {
	public DoorSensor(String name) {
		super(name);
		type = SensorType.DOOR;
		
	}
	public void enable() {
		setStatus(SensorStatus.ENABLED);
	}

	public void disable() {
		setStatus(SensorStatus.DISABLED);

	}

}
