public class SecurityControlCommandFactory {

    public static SensorControlCommand createSensorControlCommand(Sensor sensor, SensorStatus action) {
        switch (action) {
        case ENABLED:
            return new EnableSensorCommand(sensor);
        case DISABLED:
            return new DisableSensorCommand(sensor);
        default:
            return null;
        }
    }

    public static DoorLockControlCommand createDoorLockControlCommand(DoorLock doorLock, DoorLockStatus action) {
        switch (action) {
        case LOCKED:
            return new LockDoorLockCommand(doorLock);
        case UNLOCKED:
            return new UnlockDoorLockCommand(doorLock);
        default:
            return null;
        }
    }

}
