public class LockDoorLockCommand extends DoorLockControlCommand {

    public LockDoorLockCommand(DoorLock doorLock) {
        super(doorLock);
    }

    @Override
    public boolean execute() {
        doorLock.lock();
        return doorLock.getStatus() == DoorLockStatus.LOCKED;
    }

}
