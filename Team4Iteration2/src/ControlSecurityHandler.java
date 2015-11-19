import java.util.Set;

/*
 * The Controller class which will be coordinating the User Interface (UI) actions 
 * with the domain classes to perform control security transactions. 
 */
public class ControlSecurityHandler {

    House house;
    SecurityControlTransaction sct;

    /*
     * Constructs the object with referencing to the house object
     */
    public ControlSecurityHandler(House house) {
        this.house = house;
        sct = new SecurityControlTransaction();
    }

    /*
     * Gets motion sensor by name (window or door sensor based on the supplied sensor type
     * argument)
     */
    public Sensor selectSensor(SensorType type, String name) {
        Sensor sensor = null;
        if (type == SensorType.WINDOW) {
            sensor = house.getWindowSensor(name);
        } else {
            sensor = house.getDoorSensor(name);
        }
        return sensor;
    }

    /*
     * Passes the users security control action for the selected sensor into the
     * transaction object
     */
    public boolean enableDisableSensor(Sensor sensor, SensorStatus action) {
        // 1st validate all user inputs
        if (sensor == null) {
            throw new IllegalArgumentException("The sensor supplied is undefined!");
        }
        if (action == null) {
            throw new IllegalArgumentException(
                    "The sensor control action supplied is undefined!");
        }

        // try to add the user's selection where duplicate sensor is not allowed
        try {
            sct.addSensorControlAction(sensor, action);
        } catch (Exception e) {
            return false; // duplicates found
        }
        return true;
    }

    /*
     * Gets door lock sensor by name
     */
    public DoorLock selectDoorLock(String name) {
        return house.getDoorLock(name);
    }

    /*
     * Passes the user’s door lock control action to the transaction object
     */
    public boolean lockUnlockDoor(DoorLock doorLock, DoorLockStatus action) {
        // 1st validate all user inputs
        if (doorLock == null) {
            throw new IllegalArgumentException("The door lock supplied is undefined!");
        }
        if (action == null) {
            throw new IllegalArgumentException(
                    "The door lock control action supplied is undefined!");
        }

        // try to add the user's selection where duplicate house section is not allowed
        try {
            sct.addDoorLockControlAction(doorLock, action);
        } catch (Exception e) {
            return false; // duplicates found
        }
        return true;
    }

    /*
     * Indicates that user has ended sensors and door lock picking and ready to apply the
     * transaction
     */
    public TransactionStatus endControlSecurity() {
        TransactionStatus status = sct.process();
        house.logTransaction(sct, TransactionType.CONTROL_SECURITY, status);
        return status;
    }

    public SecurityControlTransaction getSecurityControlTransaction() {
        return this.sct;
    }

    /*
     * Performs the enabling of all window and door sensors. Also locking external doors
     */
    public void secureForNight() {
        Set<String> windowSensorNames = house.getWindowSensors().keySet();
        for (String sensorName : windowSensorNames) {
            Sensor sensor = selectSensor(SensorType.WINDOW, sensorName);
            enableDisableSensor(sensor, SensorStatus.ENABLED);
        }

        Set<String> doorSensorNames = house.getDoorSensors().keySet();
        for (String sensorName : doorSensorNames) {
            Sensor sensor = selectSensor(SensorType.DOOR, sensorName);
            enableDisableSensor(sensor, SensorStatus.ENABLED);
        }
        Set<String> doorLockNames = house.getDoorLocks().keySet();
        for (String doorLockName : doorLockNames) {
            DoorLock doorLock = selectDoorLock(doorLockName);
            lockUnlockDoor(doorLock, DoorLockStatus.LOCKED);
        }
        sct.setType(SecurityControlTransactionType.SECURE_FOR_NIGHT);
    }

    /*
     * Performs the disabling of all window and door sensors only.
     */
    public void goodMorning() {
        Set<String> windowSensorNames = house.getWindowSensors().keySet();
        for (String sensorName : windowSensorNames) {
            Sensor sensor = selectSensor(SensorType.WINDOW, sensorName);
            enableDisableSensor(sensor, SensorStatus.DISABLED);
        }
        Set<String> doorSensorNames = house.getDoorSensors().keySet();
        for (String sensorName : doorSensorNames) {
            Sensor sensor = selectSensor(SensorType.DOOR, sensorName);
            enableDisableSensor(sensor, SensorStatus.DISABLED);
        }
        sct.setType(SecurityControlTransactionType.GOOD_MORNING);
    }
}
