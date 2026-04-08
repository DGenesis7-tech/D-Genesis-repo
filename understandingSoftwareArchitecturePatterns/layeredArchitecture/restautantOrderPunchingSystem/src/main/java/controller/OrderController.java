package controller;

import dtos.request.PlaceOrderRequest;
import dtos.response.PlaceOrderResponse;
import services.OrderService;

public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    public PlaceOrderResponse placeOrder(String orderId, String productId, int quantity) {
        PlaceOrderRequest request = new PlaceOrderRequest();
        request.setOrderId(orderId);
        request.setProductId(productId);
        request.setQuantity(quantity);

        return service.placeOrder(request);
    }
}
