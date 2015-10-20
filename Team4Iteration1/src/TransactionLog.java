import java.util.Date;

public class TransactionLog {
	private TransactionType type;
	private Date dateTime;
	private TransactionStatus status;
	private LightingControlTransaction transaction;
	public TransactionLog(LightingControlTransaction lct, TransactionStatus status) {
		transaction = lct;
		dateTime = new Date(System.currentTimeMillis());
		type= TransactionType.controlLighting;
		this.status = status;
		
	}
	
}
