package services;

import dtos.request.PlaceOrderRequest;
import dtos.response.PlaceOrderResponse;

public interface OrderService {
    PlaceOrderResponse placeOrder(PlaceOrderRequest request);
}
