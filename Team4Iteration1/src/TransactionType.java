public enum TransactionType {

    CONTROL_LIGHTING("Control Lighting");

    private String description;

    private TransactionType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
