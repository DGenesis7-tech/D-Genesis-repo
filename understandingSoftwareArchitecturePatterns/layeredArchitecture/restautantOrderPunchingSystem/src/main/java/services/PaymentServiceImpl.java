package services;

import models.Customer;
import models.Order;
import repository.CustomerRepo;
import repository.OrderRepo;

public class PaymentServiceImpl implements PaymentService {
    private final CustomerRepo customerRepo;
    private final OrderRepo orderRepo;

    public PaymentServiceImpl(CustomerRepo customerRepo,
                              OrderRepo orderRepo) {
        this.customerRepo = customerRepo;
        this.orderRepo = orderRepo;
    }

    public String pay(String customerId, String orderId) {

        Customer customer = customerRepo.findById(customerId);
        if (customer == null) throw new IllegalArgumentException("Customer not found");

        Order order = orderRepo.findById(orderId);
        if (order == null) throw new IllegalArgumentException("Order not found");

        customer.deduct(order.getTotalAmount());
        order.complete();

        customerRepo.save(customer);
        orderRepo.save(order);

        return "Payment successful. Order completed.";
    }
}
