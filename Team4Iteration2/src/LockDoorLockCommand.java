/*
 * Command class to lock door locks implemented using the command pattern
 */
public class LockDoorLockCommand extends DoorLockControlCommand {

    public LockDoorLockCommand(DoorLock doorLock) {
        super(doorLock);
    }

    /*
     * Runs the door locking action
     */
    @Override
    public boolean execute() {
        doorLock.lock();
        return doorLock.getStatus() == DoorLockStatus.LOCKED;
    }

    @Override
    public String toString() {
        return String.format("%s, Action required: %s", doorLock.toString(),
                DoorLockStatus.LOCKED.toString());
    }
}
