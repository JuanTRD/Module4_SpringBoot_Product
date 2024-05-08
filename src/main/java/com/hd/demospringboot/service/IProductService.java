package com.hd.demospringboot.service;

import com.hd.demospringboot.model.Product;

import java.util.List;

public interface IProductService extends IGenerateService<Product>{
    List<Product> findByNameContaining(String name);
    List<Product> findByPriceBetween(double from, double to);
    List<Product> findByCategoryId(Long id);
}
