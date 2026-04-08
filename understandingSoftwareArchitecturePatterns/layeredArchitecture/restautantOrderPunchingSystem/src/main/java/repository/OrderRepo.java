package java.repository;

import java.models.Order;

public interface OrderRepo {
    void save(Order order);
    Order findById(String id);

}
