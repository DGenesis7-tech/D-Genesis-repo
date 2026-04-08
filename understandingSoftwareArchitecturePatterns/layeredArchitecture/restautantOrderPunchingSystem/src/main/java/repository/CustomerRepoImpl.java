package repository;


import models.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepoImpl implements CustomerRepo {
    private final Map<String, Customer> db = new HashMap<>();

    @Override
    public void save(Customer customer) {
        db.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(String id) {
        return db.get(id);
    }
}
