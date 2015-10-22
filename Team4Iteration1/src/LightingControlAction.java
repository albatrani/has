/*
 * LightingControlAction models the user command to switch on/off the 
 * lights in a specific HouseSection 
 */
public class LightingControlAction {

    private LightStatus action;
    private HouseSection section;

    /*
     * Creates a user defined lighting control action for a given house section
     */
    public LightingControlAction(HouseSection hs, LightStatus action) {
        section = hs;
        this.action = action;
    }

    /*
     * Applies the light control action on the house section
     */
    public boolean process() {
        section.setLightingStatus(action);
        return section.getLightingStatus() == action;
    }

    public LightStatus getAction() {
        return this.action;
    }

    public HouseSection getSection() {
        return this.section;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LightingControlAction)) {
            return false;
        }

        LightingControlAction other = (LightingControlAction) obj;
        return this.section.getName().equals(other.section.getName());
    }

    @Override
    public int hashCode() {
        return section.getName().hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s, Action required: %s", section.toString(),
                action.toString());
    }
}
