class SeatAvailability {
    String seatNumber;
    boolean isAvailable;

    public SeatAvailability(String seatNumber, boolean isAvailable) {
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
    }
    @Override
    public String toString() {
        return "SeatAvailability{" +
               "seatNumber='" + seatNumber + '\'' +
               ", isAvailable=" + isAvailable +
               '}';
    }
}
