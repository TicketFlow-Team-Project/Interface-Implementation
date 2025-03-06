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

      @Override
    public String toString() {
        return "BookingRequest{" +
               "eventId='" + eventId + '\'' +
               ", seatNumbers=" + seatNumbers +
               ", customerName='" + customerName + '\'' +
               ", paymentDetails='" + paymentDetails + '\'' +
               '}';
    }

}

