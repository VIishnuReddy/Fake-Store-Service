package com.vishnu.productservicevishnu.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends BaseModel{
    private String CategoryName;
    private String description;
}
