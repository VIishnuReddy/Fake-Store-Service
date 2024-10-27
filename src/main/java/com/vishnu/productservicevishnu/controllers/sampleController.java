package com.vishnu.productservicevishnu.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("say")
public class sampleController {

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name){
        return "hello vishnu welcome to "+name;
    }

    @GetMapping("/byee")
    public String sayBye(){
        return "bye vishnu";
    }

    @GetMapping("/bill/{price}/{units}")

    public String getBill(@PathVariable("price") int price,
                       @PathVariable("units")int units){
        return "Hi, your bills is "+ price * units;
    }
}
