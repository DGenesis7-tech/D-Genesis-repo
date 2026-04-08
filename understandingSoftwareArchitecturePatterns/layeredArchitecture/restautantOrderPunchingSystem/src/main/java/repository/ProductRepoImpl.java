package repository;


import models.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepoImpl implements ProductRepo {
    private final Map<String, Product> db = new HashMap<>();

    public void save(Product product) {
        db.put(product.getId(), product);
    }

    public Product findById(String id) {
        return db.get(id);
    }
}
