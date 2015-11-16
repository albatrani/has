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
    private Map<String, Window> windows;
    private Map<String, Door> doors;

    public House(Resident resident, String address) {
        this.resident = resident;
        this.address = address;
        trasactions = new ArrayList<>();
        sections = new HashMap<>();

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
     * Adds a log for the completed lighting control transaction
     */
    public void logTransaction(LightingControlTransaction lct, TransactionStatus status) {
        trasactions.add(new TransactionLog(lct,TransactionType.CONTROL_LIGHTING, status));
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(
                "\"%s\" house located on \"%s\" has the following sections:%n",
                resident.getName(), address));
        for (HouseSection hs : sections.values()) {
            builder.append(String.format("   %s%n", hs.toString()));
        }
        return builder.toString();
    }
    
    // iteration 2
    
    /*
     * makes the control security handler object and pass its reference back to UI
     */
    public ControlLightingHandler makeNewControlSecurity() {
        
    	return new ControlLightingHandler(this);
    }
    
    public Door getDoor(String name) {
		
    	return doors.get(name);
	}
    
    public Window getWindow(String name) {
		
    	return windows.get(name);
	}
    
    public boolean addWindow(Window w){
    	
    	if (windows.containsKey(w.getName())) {
            return false;
        }
    	windows.put(w.getName(), w);
        return true;
    	
    }
    
    public boolean addDoor(Door d){
    	
    	if (doors.containsKey(d.getName())) {
            return false;
        }
    	doors.put(d.getName(), d);
        return true;
    	
    }
    
    /*
     * Adds a log for the completed security control transaction
     */
    //public void logTransaction(SecurityControlTransaction sct, TransactionStatus status) {
        //trasactions.add(new TransactionLog(sct, status));
    //}
    
}
