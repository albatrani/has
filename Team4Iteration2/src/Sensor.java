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

    public SensorType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

}
