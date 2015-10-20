import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class House {
	
	private String address;
	private Resident resident;
	private List<TransactionLog> trasactions;
	private Map<String, HouseSection> sections;
	
	public House(Resident resident, String address) {
		// TODO Auto-generated constructor stub
		
		this.resident = resident;
		this.address = address;
		trasactions = new ArrayList<>();
		sections = new HashMap<>();
		
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public List<TransactionLog> getTrasactions() {
		return trasactions;
	}

	public void setTrasactions(List<TransactionLog> trasactions) {
		this.trasactions = trasactions;
	}

	public Map<String, HouseSection> getSections() {
		return sections;
	}

	public void setSections(Map<String, HouseSection> sections) {
		this.sections = sections;
	}

	public HouseSection getHouseSection(String name) {
		// TODO Auto-generated method stub
		
		return sections.get(name);
	}

	public void logTransaction(LightingControlTransaction lct, TransactionStatus status) {
		// TODO Auto-generated method stub
		
		trasactions.add(new TransactionLog(lct, status));
	}
	
	public void addHouseSection(HouseSection hs){
		
		if(!sections.containsKey(hs.getName())){
			sections.put(hs.getName(), hs);
		}
			
	}

}
