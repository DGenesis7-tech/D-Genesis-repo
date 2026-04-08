package services;

import dtos.request.PlaceOrderRequest;
import dtos.response.PlaceOrderResponse;
import models.Order;
import models.Product;
import repository.OrderRepo;
import repository.ProductRepo;

public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;

    public OrderServiceImpl(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    @Override
    public PlaceOrderResponse placeOrder(PlaceOrderRequest request) {

        Product product = productRepo.findById(request.getProductId());
        if (product == null) throw new IllegalArgumentException("Product not found");

        product.reduceStock(request.getQuantity());

        double total = product.getPrice() * request.getQuantity();

        Order order = orderRepo.findById(request.getOrderId());
        if (order == null) {
            order = new Order(request.getOrderId(), "T1", "DINE-IN");
        }

        order.addAmount(total);
        orderRepo.save(order);

        PlaceOrderResponse response = new PlaceOrderResponse();
        response.setMessage("Order placed successfully");
        response.setTotalAmount(order.getTotalAmount());

        return response;
    }

}
