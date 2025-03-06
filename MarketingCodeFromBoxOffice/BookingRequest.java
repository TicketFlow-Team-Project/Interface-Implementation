import java.util.List;

class BookingRequest {
    String eventId;
    List<String> seatNumbers;
    String customerName;
    String paymentDetails;

    public BookingRequest(String eventId, List<String> seatNumbers, String customerName, String paymentDetails) {
        this.eventId = eventId;
        this.seatNumbers = seatNumbers;
        this.customerName = customerName;
        this.paymentDetails = paymentDetails;
    }
}

