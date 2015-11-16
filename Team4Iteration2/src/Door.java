
public class Door {
	
	private String name;
	private DoorSensor doorSensor;
	public Door(String name) {
	doorSensor = new DoorSensor(name);
	
	}
	public String getName() {
		return name;
	}

	public Sensor getDoorSensor() {
		return doorSensor;
	}

	

}
