package repository;


import models.Product;

public interface ProductRepo {
    void save(Product product);
    Product findById(String id);
}
