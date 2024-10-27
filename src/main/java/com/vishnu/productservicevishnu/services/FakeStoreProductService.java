package com.vishnu.productservicevishnu.services;

import com.vishnu.productservicevishnu.DTO.FakeStoreProductDto;
import com.vishnu.productservicevishnu.models.Category;
import com.vishnu.productservicevishnu.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate;

    //Inject the RestTemplate into any service (e.g., FakeStoreProductService) via constructor
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
     //retrieving by using id
    @Override
    public Product getProductById(long id) {
       FakeStoreProductDto fakeStoreProductDto= restTemplate.getForObject
               ("https://fakestoreapi.com/products/" + id,
                       FakeStoreProductDto.class);
      return convertProductToFakeStore(fakeStoreProductDto);
          // return new Product()    ;
    }
        // retrieving all the products
    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos =restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertProductToFakeStore(fakeStoreProductDto));
        }
        return products;
    }

    public Product convertProductToFakeStore(FakeStoreProductDto fakeStoreProductDto) {
        Product product=new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category=new Category();
        category.setDescription(fakeStoreProductDto.getDescription());
        category.setCategoryName(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }
}
