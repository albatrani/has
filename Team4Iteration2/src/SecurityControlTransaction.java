import java.util.ArrayList;
import java.util.List;

public class SecurityControlTransaction implements ITransaction {

    private SecurityControlTransactionType type;
    private List<SensorControlCommand> scas;
    private List<DoorLockControlCommand> dlcas;

    public SecurityControlTransaction() {
        type = SecurityControlTransactionType.CUSTOM_SENSOR_LOCK_SELECTION;
        scas = new ArrayList<>();
        dlcas = new ArrayList<>();
    }

    public void addSensorControlAction(Sensor sensor, SensorStatus action) {
        SensorControlCommand sca =
                SecurityControlCommandsFactory.createSensorControlCommand(sensor, action);

        // check that the house section to be added is unique (no duplicates allowed)
        if (scas.contains(sca)) {
            throw new IllegalArgumentException(
                    "The Window/Door Sensor supplied is already selected!");
        } else {
            // otherwise it's safe to added it
            scas.add(sca);
        }
    }

    public void addDoorLockControlAction(DoorLock doorLock, DoorLockStatus action) {
        DoorLockControlCommand dlca =
                SecurityControlCommandsFactory.createDoorLockControlCommand(doorLock,
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

    public List<SensorControlCommand> getScas() {
        return this.scas;
    }

    public List<DoorLockControlCommand> getDlcas() {
        return this.dlcas;
    }
}
