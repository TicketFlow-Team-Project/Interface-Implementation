public class RefundConfirmation {
    String transactionID;
    int refundAmount;
    boolean success;

    public RefundConfirmation(String transactionID, int refundAmount){
    this.transactionID = transactionID;
    this.refundAmount = refundAmount;
  }
}
