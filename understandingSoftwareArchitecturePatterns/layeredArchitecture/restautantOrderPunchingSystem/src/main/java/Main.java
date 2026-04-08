import controller.OrderController;
import dtos.response.PlaceOrderResponse;
import models.Customer;
import models.Product;
import repository.*;
import services.OrderService;
import services.OrderServiceImpl;
import services.PaymentService;
import services.PaymentServiceImpl;

public class Main {
    public static void main(String[] args) {

        CustomerRepo customerRepo = new CustomerRepoImpl();
        ProductRepo productRepo = new ProductRepoImpl();
        OrderRepo orderRepo = new OrderRepoImpl();

        customerRepo.save(new Customer("C1", "Daniel", "mail", 10000));
        productRepo.save(new Product("P1", "Burger", 2500, 10));

        OrderService orderService = new OrderServiceImpl(orderRepo, productRepo);
        PaymentService paymentService = new PaymentServiceImpl(customerRepo, orderRepo);

        OrderController controller = new OrderController(orderService);

        controller.placeOrder("O1", "C1", "P1", 2);

        System.out.println(paymentService.pay("C1", "O1"));
    }
}
