import java.util.Date;

/*
 * TransactionLog captures the details of the transaction run in the system. 
 * The transaction is a specific implementation of the ITransaction interface. 
 */
public class TransactionLog {

    private TransactionType type;
    private Date dateTime;
    private TransactionStatus status;
    private ITransaction transaction;

    /*
     * Creates transaction log object with reference to the generic control transaction
     */
    public TransactionLog(ITransaction transaction, TransactionType type,
            TransactionStatus status) {
        this.transaction = transaction;
        this.dateTime = new Date();
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
