package com.gran.solte.exepction;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmpleadoNotFoundException extends HandlerException{
    public EmpleadoNotFoundException(String message, Integer code, 
    		HttpStatus status, LocalDateTime timestamp) {
        super(message, code, status, timestamp);
    }
}
