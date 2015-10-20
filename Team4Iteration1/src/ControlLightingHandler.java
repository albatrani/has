
public class ControlLightingHandler {
	
	House house;
	LightingControlTransaction lct;
	public ControlLightingHandler(House house) {
		// TODO Auto-generated constructor stub
		this.house = house;
		lct = new LightingControlTransaction();
	}
	
	public HouseSection selectHousesection(String name){
		
		
		return house.getHouseSection(name);
	}
	
	public void turnOnOffLighting(HouseSection hs, LightStatus action){
		
		lct.addLightControlAction(hs, action);
	}
	
	public TransactionStatus endControlLighting(){
		
		TransactionStatus status = lct.complete();
		house.logTransaction(lct, status);
		
		return status;
	}

}
