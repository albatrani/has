/*
 * Common home automation transaction interface
 */
public interface ITransaction {

    TransactionStatus process();
}
