import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * House is the main Controller class in the system which tracks the: 
 *      1. list of house sections.
 *      2. list of window sensors.
 *      3. list of door sensors.
 *      4. list of door locks.
 */
public class House {

    private String address;
    private Resident resident;
    private List<TransactionLog> trasactions;
    private Map<String, HouseSection> sections;
    private Map<String, WindowSensor> windowSensors;
    private Map<String, DoorSensor> doorSensors;
    private Map<String, DoorLock> doorLocks;

    public House(Resident resident, String address) {
        this.resident = resident;
        this.address = address;
        trasactions = new ArrayList<>();
        sections = new HashMap<>();
        windowSensors = new HashMap<>();
        doorSensors = new HashMap<>();
        doorLocks = new HashMap<>();
    }

    /*
     * gets a house section by name
     */
    public HouseSection getHouseSection(String name) {
        return sections.get(name);
    }

    /*
     * makes the control lighting handler object and pass its reference back to UI
     */
    public ControlLightingHandler makeNewControlLighting() {
        return new ControlLightingHandler(this);
    }

    /*
     * Utility method to populate the house sections list
     */
    public boolean addHouseSection(HouseSection hs) {
        if (sections.containsKey(hs.getName())) {
            return false;
        }
        sections.put(hs.getName(), hs);
        return true;
    }

    public String getAddress() {
        return address;
    }

    public Resident getResident() {
        return resident;
    }

    public List<TransactionLog> getTrasactions() {
        return trasactions;
    }

    public Map<String, HouseSection> getSections() {
        return sections;
    }

    /*
     * Builds string representation of the current status of the house lighting features.
     */
    public String getHouseLightingStatusDescription() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(
                "\"%s\" house located on \"%s\" has the following lighting status:%n",
                resident.getName(), address));
        for (HouseSection houseSection : sections.values()) {
            builder.append(String.format("   %s%n", houseSection.toString()));
        }
        return builder.toString();
    }

    /*
     * Builds string representation of the current status of the house security system
     * features.
     */
    public String getHouseSecurityStatusDescription() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(
                "\"%s\" house located on \"%s\" has the following security status:%n",
                resident.getName(), address));
        for (WindowSensor windowSensor : windowSensors.values()) {
            builder.append(String.format("   %s%n", windowSensor.toString()));
        }
        for (DoorSensor doorSensor : doorSensors.values()) {
            builder.append(String.format("   %s%n", doorSensor.toString()));
        }
        for (DoorLock doorLock : doorLocks.values()) {
            builder.append(String.format("   %s%n", doorLock.toString()));
        }
        return builder.toString();
    }

    /*
     * makes the control security handler object and pass its reference back to UI
     */
    public ControlSecurityHandler makeNewControlSecurity() {
        return new ControlSecurityHandler(this);
    }

    /*
     * gets a door lock by name
     */
    public DoorLock getDoorLock(String name) {
        return doorLocks.get(name);
    }

    /*
     * gets a door sensor by name
     */
    public DoorSensor getDoorSensor(String name) {
        return doorSensors.get(name);
    }

    /*
     * gets a window sensor by name
     */
    public WindowSensor getWindowSensor(String name) {
        return windowSensors.get(name);
    }

    /*
     * Utility method to populate the window sensors list
     */
    public boolean addWindowSensor(WindowSensor windowSensor) {
        if (windowSensors.containsKey(windowSensor.getName())) {
            return false;
        }
        windowSensors.put(windowSensor.getName(), windowSensor);
        return true;
    }

    /*
     * Utility method to populate the door sensors list
     */
    public boolean addDoorSensor(DoorSensor doorSensor) {
        if (doorSensors.containsKey(doorSensor.getName())) {
            return false;
        }
        doorSensors.put(doorSensor.getName(), doorSensor);
        return true;
    }

    /*
     * Utility method to populate the door locks list
     */
    public boolean addDoorLock(DoorLock doorLock) {
        if (doorLocks.containsKey(doorLock.getName())) {
            return false;
        }
        doorLocks.put(doorLock.getName(), doorLock);
        return true;
    }

    public Map<String, WindowSensor> getWindowSensors() {
        return this.windowSensors;
    }

    public Map<String, DoorSensor> getDoorSensors() {
        return this.doorSensors;
    }

    public Map<String, DoorLock> getDoorLocks() {
        return this.doorLocks;
    }

    /*
     * Adds a log for the completed control transactions (i.e. lighting, security, ...etc
     * as they implement the generic ITransaction interface)
     */
    public void logTransaction(ITransaction transaction, TransactionType type,
            TransactionStatus status) {
        trasactions.add(new TransactionLog(transaction, type, status));
    }
}
