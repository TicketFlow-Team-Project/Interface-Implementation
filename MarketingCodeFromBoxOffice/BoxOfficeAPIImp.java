import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoxOfficeAPIImp implements BoxOfficeAPI {
  private static final String URL = "jdbc:mysql://localhost:3306/BoxOfficeDB";
  private static final String USER = "MarketingUser";
  private static final String PASSWORD = "BoxOffice@2025";

  @Override
  public TicketSales getTicketSales(String eventId) {
    String query = "SELECT event_id, COUNT(*) AS total_tickets, SUM(price) AS total_revenue FROM tickets WHERE event_id = ? GROUP BY event_id";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(query)) {
      stmt.setString(1, eventId);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        return new TicketSales(
            rs.getString("event_id"),
            rs.getInt("total_tickets"),
            rs.getDouble("total_revenue"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public RefundConfirmation processTicketRefund(String transactionId, double refundAmount) {
    String query = "UPDATE payments SET refund_amount = ? WHERE transaction_id = ?";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(query)) {
      stmt.setDouble(1, refundAmount);
      stmt.setString(2, transactionId);
      return new RefundConfirmation(transactionId, refundAmount, true);
    } catch (SQLException e) {
      e.printStackTrace();
      return new RefundConfirmation(transactionId, refundAmount, false);
    }
  }

  @Override
  public List<SeatAvailability> getSeatAvailability(String eventId) {
    List<SeatAvailability> seats = new ArrayList<>();
    String query = "SELECT seat_number, is_available FROM seats WHERE event_id = ?";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(query)) {
      stmt.setString(1, eventId);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        seats.add(new SeatAvailability(
            rs.getString("seat_number"),
            rs.getBoolean("is_available")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seats;
  }

  @Override
  public BookingConfirmation bookTickets(BookingRequest bookingRequest) {
    String query = "INSERT INTO bookings (event_id, customer_name, payment_details) VALUES (?, ?, ?)";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
      stmt.setString(1, bookingRequest.eventId);
      stmt.setString(2, bookingRequest.customerName);
      stmt.setString(3, bookingRequest.paymentDetails);
      int rowsInserted = stmt.executeUpdate();
      if (rowsInserted > 0) {
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys.next()) {
          return new BookingConfirmation(
              generatedKeys.getString(1),
              true,
              "Booking successful.");
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return new BookingConfirmation(null, false, "Booking failed.");
  }
}
