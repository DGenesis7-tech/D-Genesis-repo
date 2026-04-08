package java.repository;

import java.models.Customer;

public interface CustomerRepo {
    void save(Customer customer);

    Customer findById(String id);
}
