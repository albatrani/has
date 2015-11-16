public class DoorLock {

    private DoorLockStatus status;
    private String name;

    public DoorLock(String name) {
        this.name = name;
        status = DoorLockStatus.UNLOCKED;
    }

    public void lock() {
        status = DoorLockStatus.LOCKED;
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
}
