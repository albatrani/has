/*
 * Command class to switch off the light of a house section 
 * implemented using the command pattern
 */
public class SwitchOffLightCommand extends LightingControlCommand {

    public SwitchOffLightCommand(HouseSection hs) {
        super(hs);
    }

    /*
     * Performs the switching off for the light
     */
    @Override
    public boolean execute() {
        section.switchOffLights();
        return section.getLightingStatus() == LightStatus.OFF;
    }

    @Override
    public String toString() {
        return String.format("%s, Action required: %s", section.toString(),
                LightStatus.OFF.toString());
    }
}
