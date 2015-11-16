/*
 * Possible transaction outcomes  
 */
public enum TransactionStatus {
    SUCCESSFUL("Successful"), FAILED("Failed");

    private String description;

    private TransactionStatus(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
