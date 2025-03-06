class BookingConfirmation {
    String bookingId;
    boolean success;
    String message;

    public BookingConfirmation(String bookingId, boolean success, String message) {
        this.bookingId = bookingId;
        this.success = success;
        this.message = message;
    }
    public boolean isSuccess() {
      return success;
    }
      @Override
    public String toString() {
        return "BookingConfirmation{" +
               "bookingId='" + bookingId + '\'' +
               ", success=" + success +
               ", message='" + message + '\'' +
               '}';
    }

}

