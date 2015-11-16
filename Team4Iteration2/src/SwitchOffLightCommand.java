public class SwitchOffLightCommand extends LightingControlCommand {

    public SwitchOffLightCommand(HouseSection hs) {
        super(hs);
    }

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
