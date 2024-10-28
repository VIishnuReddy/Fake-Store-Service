package com.vishnu.productservicevishnu.services;

import com.vishnu.productservicevishnu.DTO.FakeStoreProductDto;
import com.vishnu.productservicevishnu.exceptions.ProductNotFoundException;
import com.vishnu.productservicevishnu.models.Category;
import com.vishnu.productservicevishnu.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
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
    public Product getProductById(Long id) throws ProductNotFoundException {

       FakeStoreProductDto fakeStoreProductDto= restTemplate.getForObject
               ("https://fakestoreapi.com/products/" + id,
                       FakeStoreProductDto.class);
       if(fakeStoreProductDto == null){
        throw new ProductNotFoundException("Please enter a valid id");
       }
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

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public Product updateProduct(Long id, Product product) {
        // updating whole product using Patch method
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class,
                restTemplate.getMessageConverters());

        FakeStoreProductDto response= restTemplate.execute("https://fakestoreapi.com/products/"+id,
                HttpMethod.PATCH, requestCallback, responseExtractor);

        return convertProductToFakeStore(response);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
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
