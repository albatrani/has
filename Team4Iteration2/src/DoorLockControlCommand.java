/*
 * Base command class to describe door lock actions implemented using the command pattern
 */
public abstract class DoorLockControlCommand implements ICommand {

    protected DoorLock doorLock;

    protected DoorLockControlCommand(DoorLock doorLock) {
        this.doorLock = doorLock;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DoorLockControlCommand)) {
            return false;
        }

        DoorLockControlCommand other = (DoorLockControlCommand) obj;
        return this.doorLock.getName().equals(other.doorLock.getName());
    }

    @Override
    public int hashCode() {
        return doorLock.getName().hashCode();
    }

    public DoorLock getSensor() {
        return doorLock;
    }
}
