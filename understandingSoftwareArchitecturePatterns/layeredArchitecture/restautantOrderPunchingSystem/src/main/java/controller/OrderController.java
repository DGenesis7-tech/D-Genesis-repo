package controller;

import dtos.request.PlaceOrderRequest;
import dtos.response.PlaceOrderResponse;
import services.OrderService;

public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    public PlaceOrderResponse placeOrder(String orderId, String customerId, String productId, int qty) {

        PlaceOrderRequest req = new PlaceOrderRequest();
        req.setOrderId(orderId);
        req.setCustomerId(customerId);
        req.setProductId(productId);
        req.setQuantity(qty);

        return service.placeOrder(req);
    }
}
