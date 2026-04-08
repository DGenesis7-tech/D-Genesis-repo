package repository;


import models.Order;

public interface OrderRepo {
    void save(Order order);
    Order findById(String id);

}
