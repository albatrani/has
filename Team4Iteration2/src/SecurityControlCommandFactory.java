public class SecurityControlCommandFactory {

    public static SensorControlCommand createSensorControlCommand(Sensor sensor,
            SensorStatus action) {

        switch (sensor.getType()) {
        case DOOR:
            return createDoorSensorControlCommand(sensor, action);
        case WINDOW:
            return createWindowSensorControlCommand(sensor, action);
        default:
            return null;
        }
    }

    private static SensorControlCommand createWindowSensorControlCommand(Sensor sensor,
            SensorStatus action) {
        switch (action) {
        case ENABLED:
            return new EnableWindowSensorCommand(sensor);
        case DISABLED:
            return new DisableWindowSensorCommand(sensor);
        default:
            return null;
        }
    }

    private static SensorControlCommand createDoorSensorControlCommand(Sensor sensor,
            SensorStatus action) {
        switch (action) {
        case ENABLED:
            return new EnableDoorSensorCommand(sensor);
        case DISABLED:
            return new DisableDoorSensorCommand(sensor);
        default:
            return null;
        }
    }

    public static DoorLockControlCommand createDoorLockControlCommand(DoorLock doorLock,
            DoorLockStatus action) {
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
