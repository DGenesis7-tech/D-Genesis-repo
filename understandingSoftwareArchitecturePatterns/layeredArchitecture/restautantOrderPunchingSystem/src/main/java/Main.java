import controller.OrderController;
import dtos.response.PlaceOrderResponse;
import models.Product;
import repository.OrderRepo;
import repository.OrderRepoImpl;
import repository.ProductRepo;
import repository.ProductRepoImpl;
import services.OrderService;
import services.OrderServiceImpl;

public class Main {
    public static void main(String[] args) {

        ProductRepo productRepo = new ProductRepoImpl();
        OrderRepo orderRepo = new OrderRepoImpl();

        productRepo.save(new Product("P1", "Burger", 2500, 10));

        OrderService service = new OrderServiceImpl(orderRepo, productRepo);
        OrderController controller = new OrderController(service);

        PlaceOrderResponse response = controller.placeOrder("O1", "P1", 2);

        System.out.println(response.getMessage());
        System.out.println("Total: " + response.getTotalAmount());
    }
}
