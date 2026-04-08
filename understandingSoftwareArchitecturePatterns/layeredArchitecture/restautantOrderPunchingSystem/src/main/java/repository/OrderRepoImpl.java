package repository;


import models.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderRepoImpl implements OrderRepo {
    private final Map<String, Order> db = new HashMap<>();

    public void save(Order order) {
        db.put(order.getId(), order);
    }

    public Order findById(String id) {
        return db.get(id);
    }
}
