/*
 * LightAdapter is the facade to the physical light system 
 */
public class LightAdapter {

    private LightStatus lightStatus;

    public LightAdapter() {
        lightStatus = getLightStatus();
        if (lightStatus == null) {
            lightStatus = LightStatus.OFF;
        }
    }

    /*
     * Communicates with the hardware to switch on the lights
     */
    public void on() {
        lightStatus = LightStatus.ON;
    }

    /*
     * Communicates with the hardware to switch off the lights
     */
    public void off() {
        lightStatus = LightStatus.OFF;
    }

    /*
     * Communicates with the hardware to get lighting status
     */
    public LightStatus getLightStatus() {
        return lightStatus;
    }
}
