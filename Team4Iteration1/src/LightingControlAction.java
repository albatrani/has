
public class LightingControlAction {
	private LightStatus action;
	private HouseSection section;
	public LightingControlAction(HouseSection hs,LightStatus action) {
		section = hs;
		this.action = action;
	}
	public boolean process() {
		
		section.setLightingStatus(action);
		return section.getLightingStatus() == action;

	}
}
