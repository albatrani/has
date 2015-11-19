import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * House is the main Controller class in the system which maintains the 
 * list of house sections.
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

    public DoorLock getDoorLock(String name) {
        return doorLocks.get(name);
    }

    public DoorSensor getDoorSensor(String name) {
        return doorSensors.get(name);
    }

    public WindowSensor getWindowSensor(String name) {
        return windowSensors.get(name);
    }

    public boolean addWindowSensor(WindowSensor windowSensor) {
        if (windowSensors.containsKey(windowSensor.getName())) {
            return false;
        }
        windowSensors.put(windowSensor.getName(), windowSensor);
        return true;
    }

    public boolean addDoorSensor(DoorSensor doorSensor) {
        if (doorSensors.containsKey(doorSensor.getName())) {
            return false;
        }
        doorSensors.put(doorSensor.getName(), doorSensor);
        return true;
    }

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
     * Adds a log for the completed control transaction
     */
    public void logTransaction(ITransaction transaction, TransactionType type,
            TransactionStatus status) {
        trasactions.add(new TransactionLog(transaction, type, status));
    }
}
