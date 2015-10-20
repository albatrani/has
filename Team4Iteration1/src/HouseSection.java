
public class HouseSection {
	
	private String name;
	private boolean inHouse = true;
	private LightAdapter lightAdapter = new LightAdapter();
	
	public void setLightingStatus(LightStatus action){
		
		switch(action){
		case On:
			lightAdapter.on();
		case Off:
			lightAdapter.off();
		}
	}

	public LightStatus getLightingStatus() {
		
		return lightAdapter.getLightStatus();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isInHouse() {
		return inHouse;
	}

	public void setInHouse(boolean inHouse) {
		this.inHouse = inHouse;
	}
	

}
