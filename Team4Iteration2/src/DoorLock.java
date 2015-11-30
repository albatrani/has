/*
 * Models the door lock object 
 */
public class DoorLock {

    private DoorLockStatus status;
    private String name;

    public DoorLock(String name) {
        this.name = name;
        status = DoorLockStatus.UNLOCKED;
    }

    /*
     * Locks the door
     */
    public void lock() {
        status = DoorLockStatus.LOCKED;
        logDoorLockStatusChange();
    }

    private void logDoorLockStatusChange() {
        System.out.printf("Door lock of %s was %s%n", name, status);
    }

    /*
     * Unlocks the door
     */
    public void unlock() {
        status = DoorLockStatus.UNLOCKED;
        logDoorLockStatusChange();
    }

    /*
     * Gets current door lock sensor status
     */
    public DoorLockStatus getStatus() {
        return this.status;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("Door Lock: %s, Current Status: %s", name, status);
    }
}
