package com.hd.demospringboot.controller;

import com.hd.demospringboot.model.Product;
import com.hd.demospringboot.service.ICategoryService;
import com.hd.demospringboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> list = productService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        productService.save(product);
        String message = "Add successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> editProduct(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        productService.save(product);
        String message = "Edit successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.remove(id);
        String message = "Delete successfully";
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
    @GetMapping("/searchName")
    public ResponseEntity<List<Product>> searchName(@RequestParam String name){
        List<Product> list = productService.findByNameContaining(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> searchCategory(@PathVariable Long id){
        List<Product> list = productService.findByCategoryId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("searchPrice")
    public ResponseEntity<List<Product>> searchPrice(@RequestParam double from, @RequestParam double to){
        List<Product> list = productService.findByPriceBetween(from, to);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
