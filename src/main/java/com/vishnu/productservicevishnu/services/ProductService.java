package com.vishnu.productservicevishnu.services;

import com.vishnu.productservicevishnu.models.Product;

import java.util.List;

public interface ProductService {

   Product getProductById(long id);

   List<Product> getAllProducts();
}
