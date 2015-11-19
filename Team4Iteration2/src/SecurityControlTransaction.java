import java.util.ArrayList;
import java.util.List;

/*
 * SecurityControlTransaction represents the whole cycle of control security.
 * The class captures the list of window/door sensors and their desired sensor control 
 * action to be performed. Also captures the list of door locks and their desired 
 * door lock control action to be performed. 
 */
public class SecurityControlTransaction implements ITransaction {

    private SecurityControlTransactionType type;
    private List<SensorControlCommand> scas;
    private List<DoorLockControlCommand> dlcas;

    public SecurityControlTransaction() {
        type = SecurityControlTransactionType.CUSTOM_SENSOR_LOCK_SELECTION;
        scas = new ArrayList<>();
        dlcas = new ArrayList<>();
    }

    /*
     * Adds the user window/door sensor control action for a specific window/door sensor
     * and stores it in the list of selected window/door sensors
     */
    public void addSensorControlAction(Sensor sensor, SensorStatus action) {
        SensorControlCommand sca =
                SecurityControlCommandFactory.createSensorControlCommand(sensor, action);

        // check that the house section to be added is unique (no duplicates allowed)
        if (scas.contains(sca)) {
            throw new IllegalArgumentException(
                    "The Window/Door Sensor supplied is already selected!");
        } else {
            // otherwise it's safe to added it
            scas.add(sca);
        }
    }

    /*
     * Adds the user door lock control action for a door lock and stores it in the list of
     * selected door locks
     */
    public void addDoorLockControlAction(DoorLock doorLock, DoorLockStatus action) {
        DoorLockControlCommand dlca =
                SecurityControlCommandFactory.createDoorLockControlCommand(doorLock,
                        action);

        // check that the house section to be added is unique (no duplicates allowed)
        if (dlcas.contains(dlca)) {
            throw new IllegalArgumentException(
                    "The Door Lock supplied is already selected!");
        } else {
            // otherwise it's safe to added it
            dlcas.add(dlca);
        }
    }

    /*
     * Executes the security control transaction by processing every window/door sensor
     * and door lock control actions
     */
    @Override
    public TransactionStatus process() {
        for (SensorControlCommand sca : scas) {
            if (!sca.execute()) {
                return TransactionStatus.FAILED;
            }
        }
        for (DoorLockControlCommand dlca : dlcas) {
            if (!dlca.execute()) {
                return TransactionStatus.FAILED;
            }
        }
        return TransactionStatus.SUCCESSFUL;
    }

    public SecurityControlTransactionType getType() {
        return this.type;
    }

    public void setType(SecurityControlTransactionType type) {
        this.type = type;
    }

    public List<SensorControlCommand> getSensorControlCommands() {
        return this.scas;
    }

    public List<DoorLockControlCommand> getDoorLockControlCommands() {
        return this.dlcas;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(
                "Security Control Transaction (type: %s) with user selections as:%n",
                type));
        for (SensorControlCommand sca : scas) {
            builder.append(String.format("   %s%n", sca.toString()));
        }
        for (DoorLockControlCommand dlca : dlcas) {
            builder.append(String.format("   %s%n", dlca.toString()));
        }
        return builder.toString();
    }
}
