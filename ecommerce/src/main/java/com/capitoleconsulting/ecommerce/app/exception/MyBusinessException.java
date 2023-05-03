package com.capitoleconsulting.ecommerce.app.exception;

import lombok.AllArgsConstructor;


public class MyBusinessException extends  RuntimeException{


    public MyBusinessException(String message) {
        super(message);
    }
}
