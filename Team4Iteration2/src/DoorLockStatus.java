/*
 * DoorLockStatus enumeration for the possible door lock states
 */
public enum DoorLockStatus {

    LOCKED("Locked"), UNLOCKED("Unlocked");

    private String description;

    private DoorLockStatus(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }

}
