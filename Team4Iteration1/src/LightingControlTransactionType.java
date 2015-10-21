/*
 * The different modes that LightingControlTransaction can be executed as.
 */
public enum LightingControlTransactionType {

    SWITCH_ALL_LIGHTS_ON("Switch on all house lights"), SWITCH_ALL_LIGHTS_OFF(
            "Switch off all house lights"), CUSTOM_LIGHTS_SELECTION(
            "Control custom selected lights");

    private String description;

    private LightingControlTransactionType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
