
public class LightAdapter {
	private LightStatus lightStatus;

	public void on(){
		lightStatus = LightStatus.On;
	}

	public void off(){
		lightStatus = LightStatus.Off;
	}

	public LightStatus getLightStatus(){
		return lightStatus;
	}
}
