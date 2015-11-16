public class UnlockDoorLockCommand extends DoorLockControlCommand {

    public UnlockDoorLockCommand(DoorLock doorLock) {
        super(doorLock);
    }

    @Override
    public boolean execute() {
        doorLock.unlock();
        return doorLock.getStatus() == DoorLockStatus.UNLOCKED;
    }

}
