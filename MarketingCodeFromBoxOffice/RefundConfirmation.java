public class RefundConfirmation {
  String transactionID;
  double refundAmount;
  boolean success;

  public RefundConfirmation(String transactionID, double refundAmount, boolean success) {
    this.transactionID = transactionID;
    this.refundAmount = refundAmount;
    this.success = success;
  }
  public boolean isSuccess() {
    return success;
  }

      @Override
    public String toString() {
        return "RefundConfirmation{" +
               "transactionID='" + transactionID + '\'' +
               ", refundAmount=" + refundAmount +
               ", success=" + success +
               '}';
    }

}
