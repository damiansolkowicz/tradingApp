package pl.trading.trading.service;


import pl.trading.trading.entity.Supplier;

import java.util.List;

public interface SupplierService {

    void save(Supplier supplier);

    void update(Supplier supplier);

    Supplier findById(Long id);

    List<Supplier> findAll();

    List<Supplier> findSupplierByUserEmail(String email);

    void deleteById(Long id);
}
