public enum TransactionType {

    CONTROL_LIGHTING("Control Lighting"), CONTROL_HVAC(
            "Control Heating, Ventilation and Air Conditioning"), CONTROL_SECURITY(
            "Control Security"), CONTROL_SURVEILLANCE("Control Surveillance"),
    CONTROL_HOME_THEATER("Control Home Theater"),
    CONTROL_IRRIGATION("Control Irrigation"), ;

    private String description;

    private TransactionType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
