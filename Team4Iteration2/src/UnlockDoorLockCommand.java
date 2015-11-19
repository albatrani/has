public class UnlockDoorLockCommand extends DoorLockControlCommand {

    public UnlockDoorLockCommand(DoorLock doorLock) {
        super(doorLock);
    }

    @Override
    public boolean execute() {
        doorLock.unlock();
        return doorLock.getStatus() == DoorLockStatus.UNLOCKED;
    }

    @Override
    public String toString() {
        return String.format("%s, Action required: %s", doorLock.toString(),
                DoorLockStatus.UNLOCKED.toString());
    }
}
