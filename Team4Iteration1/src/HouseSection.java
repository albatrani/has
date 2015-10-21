/*
 * HouseSection models one part of the house identified by name such as:
 * Master Bedroom, Living room, Door Way, ...etc.
 */
public class HouseSection {

    private String name;
    private boolean inHouse = true;
    private LightAdapter lightAdapter = new LightAdapter();

    public HouseSection(String name, boolean inHouse) {
        this.name = name;
        this.inHouse = inHouse;
    }

    /*
     * Updates lighting status (On/Off) for this house section. Communication is carried
     * via the light adapter object
     */
    public void setLightingStatus(LightStatus action) {
        switch (action) {
        case ON:
            lightAdapter.on();
            break;
        case OFF:
            lightAdapter.off();
            break;
        }
        System.out.printf("%s light is %s%n", name, lightAdapter.getLightStatus());
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

}
