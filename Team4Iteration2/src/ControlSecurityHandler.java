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

    public Sensor selectSensor(SensorType type, String name) {
        Sensor sensor = null;
        if (type == SensorType.WINDOW) {
            Window window = house.getWindow(name);
            if (window != null) {
                sensor = window.getWindowSensor();
            }
        } else {
            Door door = house.getDoor(name);
            if (door != null) {
                sensor = door.getDoorSensor();
            }
        }
        return sensor;
    }

    /*
     * Passes the users security control action to the transaction object
     */
    public boolean enableDisableSensor(Sensor sensor, SensorStatus action) {
        // 1st validate all user inputs
        if (sensor == null) {
            throw new IllegalArgumentException("The sensor supplied is undefined!");
        }
        if (action == null) {
            throw new IllegalArgumentException(
                    "The security action supplied is undefined!");
        }

        // try to add the user's selection where duplicate house section is not allowed
        try {
            sct.addSensorControlAction(sensor, action);
        } catch (Exception e) {
            return false; // duplicates found
        }
        return true;
    }

    public DoorLock selectDoorLock(String name) {
        Door door = house.getDoor(name);
        if (door != null) {
            return door.getDoorLock();
        }
        return null;
    }

    /*
     * Passes the users security control action to the transaction object
     */
    public boolean lockUnlockDoor(DoorLock doorLock, DoorLockStatus action) {
        // 1st validate all user inputs
        if (doorLock == null) {
            throw new IllegalArgumentException("The door lock supplied is undefined!");
        }
        if (action == null) {
            throw new IllegalArgumentException(
                    "The door lock action supplied is undefined!");
        }

        // try to add the user's selection where duplicate house section is not allowed
        try {
            sct.addDoorLockControlAction(doorLock, action);
        } catch (Exception e) {
            return false; // duplicates found
        }
        return true;
    }

    public TransactionStatus endControlSecurity() {
        TransactionStatus status = sct.process();
        house.logTransaction(sct, TransactionType.CONTROL_SECURITY, status);
        return status;
    }

    public SecurityControlTransaction getSecurityControlTransaction() {
        return this.sct;
    }
}
