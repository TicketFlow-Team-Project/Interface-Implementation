class BookingConfirmation {
    String bookingId;
    boolean success;
    String message;

    public BookingConfirmation(String bookingId, boolean success, String message) {
        this.bookingId = bookingId;
        this.success = success;
        this.message = message;
    }
}

