package pl.trading.trading.service;


import pl.trading.trading.entity.Product;

import java.util.List;

public interface ProductsService {

    void save(Product product);

    void update(Product product);

    Product findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);

    List<Product> findBySupplierId(Long id);

    List<Product> findBySupplierPesel(String pesel);

    List<Product> findByUserEmail(String email);
}
