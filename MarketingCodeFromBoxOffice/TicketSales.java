class TicketSales {
  String eventID;
  int TotalTicketSold;
  double TotalRevenue;

  public TicketSales(String eventID, int totalTicketSold, double totalRevenue) {
    this.eventID = eventID;
    TotalTicketSold = totalTicketSold;
    TotalRevenue = totalRevenue;
  }

  public int getTotalTicketSold() {
    return TotalTicketSold;
  }

  public double getTotalRevenue() {
    return TotalRevenue;
  }
  public String getEventID() {
    return eventID;
  }
  public void setTotalTicketSold(int totalTicketSold) {
    TotalTicketSold = totalTicketSold;
  }
  public void setTotalRevenue(double totalRevenue) {
    TotalRevenue = totalRevenue;
  }
  
}
