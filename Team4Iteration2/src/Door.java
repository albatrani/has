public class Door {

    private String name;
    private DoorSensor doorSensor;
    private DoorLock doorLock;

    public Door(String name) {
        doorSensor = new DoorSensor(name);
        doorLock = new DoorLock(name);
    }

    public String getName() {
        return name;
    }

    public Sensor getDoorSensor() {
        return doorSensor;
    }

    public DoorLock getDoorLock() {
        return doorLock;
    }

}
