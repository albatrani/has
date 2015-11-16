public class SwitchOnLightCommand extends LightingControlCommand {

    public SwitchOnLightCommand(HouseSection hs) {
        super(hs);
    }

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
