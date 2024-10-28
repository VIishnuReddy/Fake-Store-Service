package com.vishnu.productservicevishnu.services;

import com.vishnu.productservicevishnu.exceptions.ProductNotFoundException;
import com.vishnu.productservicevishnu.models.Product;

import java.util.List;

public interface ProductService {

   Product getProductById(Long id) throws ProductNotFoundException;

   List<Product> getAllProducts();

   void deleteProduct(Long id);

   Product updateProduct(Long id,Product product);

   Product replaceProduct(Long id,Product product);
}
