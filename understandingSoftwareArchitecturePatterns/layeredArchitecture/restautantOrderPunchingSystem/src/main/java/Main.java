import controller.OrderController;
import models.Customer;
import models.Product;
import repository.*;
import services.OrderService;
import services.OrderServiceImpl;
import services.PaymentService;
import services.PaymentServiceImpl;

public class Main {
    static void main(String[] args) {

        CustomerRepo customerRepo = new CustomerRepoImpl();
        ProductRepo productRepo = new ProductRepoImpl();
        OrderRepo orderRepo = new OrderRepoImpl();
        OrderService orderService = new OrderServiceImpl(orderRepo, productRepo);
        OrderController orderController = new OrderController(orderService);

        customerRepo.save(new Customer("C1", "Daniel", "mail", 10000));
        productRepo.save(new Product("P1", "Burger", 2500, 10));


        System.out.println("Place Order");


        System.out.println(orderController.placeOrder("O1", "C1", "P1", 2));

        OrderService orderService2 = new OrderServiceImpl(orderRepo, productRepo);
        PaymentService paymentService = new PaymentServiceImpl(customerRepo, orderRepo);

        OrderController controller = new OrderController(orderService2);

        controller.placeOrder("O1", "C1", "P1", 2);

        System.out.println(paymentService.pay("C1", "O1"));
    }
}
