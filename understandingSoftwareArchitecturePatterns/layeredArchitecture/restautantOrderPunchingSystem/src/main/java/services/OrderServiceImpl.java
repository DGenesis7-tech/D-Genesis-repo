package services;

import dtos.request.PlaceOrderRequest;
import dtos.response.PlaceOrderResponse;
import models.Customer;
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

    public PlaceOrderResponse placeOrder(PlaceOrderRequest request) {

        Product product = productRepo.findById(request.getProductId());
        if (product == null) throw new IllegalArgumentException("Product not found");

        product.reduceStock(request.getQuantity());

        double total = product.getPrice() * request.getQuantity();

        Order order = orderRepo.findById(request.getOrderId());
        if (order == null) order = new Order(request.getOrderId());

        order.addAmount(total);

        orderRepo.save(order);
        productRepo.save(product);

        PlaceOrderResponse res = new PlaceOrderResponse();
        res.setMessage("Order placed successfully");
        res.setTotalAmount(order.getTotalAmount());

        return res;
    }

}
