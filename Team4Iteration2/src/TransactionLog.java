import java.util.Date;

/*
 * TransactionLog captures the details of the transaction run in the system. 
 * Currently it is defined to model LightingControlTransaction only. 
 */
public class TransactionLog {

    private TransactionType type;
    private Date dateTime;
    private TransactionStatus status;
    private ITransaction transaction;

    /*
     * Creates transaction log object with reference the control lighting transaction
     */
    public TransactionLog(ITransaction lct,TransactionType type, TransactionStatus status) {
        transaction = lct;
        dateTime = new Date();
        this.type = type;
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

    public ITransaction getTransaction() {
        return this.transaction;
    }
}
