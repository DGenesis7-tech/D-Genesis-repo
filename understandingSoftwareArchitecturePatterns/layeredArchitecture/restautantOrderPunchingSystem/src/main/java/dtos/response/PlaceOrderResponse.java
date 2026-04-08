package dtos.response;

public class PlaceOrderResponse {
    private String message;
    private double totalAmount;

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}
