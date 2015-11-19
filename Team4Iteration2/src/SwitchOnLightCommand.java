/*
 * Command class to switch on the light of a house section 
 * implemented using the command pattern
 */
public class SwitchOnLightCommand extends LightingControlCommand {

    public SwitchOnLightCommand(HouseSection hs) {
        super(hs);
    }

    /*
     * Performs the switching on for the light
     */
    @Override
    public boolean execute() {
        section.switchOnLights();
        return section.getLightingStatus() == LightStatus.ON;
    }

    @Override
    public String toString() {
        return String.format("%s, Action required: %s", section.toString(),
                LightStatus.ON.toString());
    }
}
