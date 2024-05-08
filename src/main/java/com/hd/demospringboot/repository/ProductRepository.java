package com.hd.demospringboot.repository;


import com.hd.demospringboot.model.Category;
import com.hd.demospringboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByNameContaining(String name);
    List<Product> findByPriceBetween(double from, double to);
    List<Product> findByCategoryId(Long id);

}
