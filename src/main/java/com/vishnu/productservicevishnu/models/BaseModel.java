package com.vishnu.productservicevishnu.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// creating a parent class so that there is no need to declare same variables in all child classes
// declare in parent class, child will inherit
@Getter
@Setter
public class BaseModel {
    private Long id;
    private Date created;
    private Date updated;
}
