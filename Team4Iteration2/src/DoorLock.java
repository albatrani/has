public class DoorLock {

    private DoorLockStatus status;
    private String name;

    public DoorLock(String name) {
        this.name = name;
        status = DoorLockStatus.UNLOCKED;
        logDoorLockStatusChange();
    }

    public void lock() {
        status = DoorLockStatus.LOCKED;
        logDoorLockStatusChange();
    }

    private void logDoorLockStatusChange() {
        System.out.printf("Door lock of %s was %s%n", name, status);
    }

    public void unlock() {
        status = DoorLockStatus.UNLOCKED;
    }

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
