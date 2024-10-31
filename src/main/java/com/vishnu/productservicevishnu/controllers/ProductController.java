package com.vishnu.productservicevishnu.controllers;

import com.vishnu.productservicevishnu.exceptions.ProductNotFoundException;
import com.vishnu.productservicevishnu.models.Product;
import com.vishnu.productservicevishnu.services.FakeStoreProductService;
import com.vishnu.productservicevishnu.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
//
    ProductController(@Qualifier("selfProductService")
                      ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductByid(@PathVariable("id") Long id) throws ProductNotFoundException {
//        ResponseEntity<Product> responseEntity=null;
//        try {
//            Product product = productService.getProductById(id);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//
//        } catch (RuntimeException | ProductNotFoundException e){
//            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        ResponseEntity<Product> responseEntity=new ResponseEntity<>(
                productService.getProductById(id),
                HttpStatus.OK
        );
        return responseEntity;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.replaceProduct(id,product);
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }

}
