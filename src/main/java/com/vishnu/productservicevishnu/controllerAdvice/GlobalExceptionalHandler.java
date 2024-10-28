package com.vishnu.productservicevishnu.controllerAdvice;

import com.vishnu.productservicevishnu.DTO.ExceptionDto;
import com.vishnu.productservicevishnu.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmaticExceptions(){
        ResponseEntity<String> responseEntity= new ResponseEntity<>(
             "Something went wrong",
                HttpStatus.BAD_REQUEST
        );
        return responseEntity;
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(){
        ExceptionDto exceptionDto=new ExceptionDto();
        exceptionDto.setMessage("Product Not Found");
        exceptionDto.setSolution("enter a valid id below 20");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.NOT_FOUND);
        return response;
    }

}
