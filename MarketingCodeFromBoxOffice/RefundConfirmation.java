public class RefundConfirmation {
  String transactionID;
  double refundAmount;
  boolean success;

  public RefundConfirmation(String transactionID, double refundAmount, boolean success) {
    this.transactionID = transactionID;
    this.refundAmount = refundAmount;
    this.success = success;
  }

}
