/*
 * LightStatus enumeration for the possible light states
 */
public enum LightStatus {

    ON("On"), OFF("Off");

    private String description;

    private LightStatus(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }

}
