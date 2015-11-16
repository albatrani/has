/*
 * HouseSection models one part of the house identified by name such as:
 * Master Bedroom, Living room, Door Way, ...etc.
 */
public class HouseSection {

    private String name;
    private boolean inHouse = true;
    private LightAdapter lightAdapter;

    public HouseSection(String name, boolean inHouse) {
        this.name = name;
        this.inHouse = inHouse;
        lightAdapter = new LightAdapter();
    }

    /*
     * Gets current lighting status for the house section
     */
    public LightStatus getLightingStatus() {
        return lightAdapter.getLightStatus();
    }

    public String getName() {
        return name;
    }

    public boolean isInHouse() {
        return inHouse;
    }

    public LightAdapter getLightAdapter() {
        return this.lightAdapter;
    }

    @Override
    public String toString() {
        return String.format("Section: %s, Current Light Status: %s", name,
                getLightingStatus());
    }

    /*
     * switches OFF the lights for this house section. Communication is carried via the
     * light adapter object
     */
    public void switchOffLights() {
        lightAdapter.off();
        logLightStatusChange();
    }

    private void logLightStatusChange() {
        System.out.printf("%s light is switched %s%n", name,
                lightAdapter.getLightStatus());
    }

    /*
     * switches ON the lights for this house section. Communication is carried via the
     * light adapter object
     */
    public void switchOnLights() {
        lightAdapter.on();
        logLightStatusChange();
    }
}
