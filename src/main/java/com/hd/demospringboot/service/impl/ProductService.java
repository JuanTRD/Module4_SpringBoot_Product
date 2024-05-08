package com.hd.demospringboot.service.impl;


import com.hd.demospringboot.model.Product;
import com.hd.demospringboot.repository.ProductRepository;
import com.hd.demospringboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.get();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }


    @Override
    public List<Product> findByNameContaining(String name) {
        List<Product> list = productRepository.findByNameContaining(name);
        return list;
    }

    @Override
    public List<Product> findByPriceBetween(double from, double to) {
        List<Product> list = productRepository.findByPriceBetween(from, to);
        return list;
    }

    @Override
    public List<Product> findByCategoryId(Long id) {
        List<Product> list = productRepository.findByCategoryId(id);
        return list;
    }

}
