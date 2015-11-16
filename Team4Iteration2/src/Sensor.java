public abstract class Sensor {
	protected SensorStatus status;
	protected SensorType type;
	private String name; 
	protected Sensor(String name) {
		this.name = name;
		status = SensorStatus.DISABLED;
		
	}
	public abstract void enable();
	public abstract void disable();
	public SensorStatus getStatus() {
		return status;
	}
	public void setStatus(SensorStatus status) {
		this.status = status;
	}
	public SensorType getType() {
		return type;
	}
	public void setType(SensorType type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}

}
