package java.repository;

import java.models.Product;

public interface ProductRepo {
    void save(Product product);
    Product findById(String id);
}
