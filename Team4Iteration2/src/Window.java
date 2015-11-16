
public class Window {

	private String name;
	private WindowSensor windowSensor;
	public Window(String name) {
	windowSensor = new WindowSensor(name);
	
	}
	public String getName() {
		return name;
	}

	public Sensor getWindowSensor() {
		
		return windowSensor;
	}

}
