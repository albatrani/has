import java.util.Date;

/*
 * TransactionLog captures the details of the transaction run in the system. 
 * Currently it is defined to model LightingControlTransaction only. 
 */
public class TransactionLog {

    private TransactionType type;
    private Date dateTime;
    private TransactionStatus status;
    private LightingControlTransaction transaction;

    /*
     * Creates transaction log object with reference the control lighting transaction
     */
    public TransactionLog(LightingControlTransaction lct, TransactionStatus status) {
        transaction = lct;
        dateTime = new Date();
        type = TransactionType.CONTROL_LIGHTING;
        this.status = status;
    }

    public TransactionType getType() {
        return this.type;
    }

    public Date getDateTime() {
        return this.dateTime;
    }

    public TransactionStatus getStatus() {
        return this.status;
    }

    public LightingControlTransaction getTransaction() {
        return this.transaction;
    }
}
