package com.vishnu.productservicevishnu.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {

   private long id;
    private String title;
    private String category;
    private String description;
    private double price;
    private String image;

}
