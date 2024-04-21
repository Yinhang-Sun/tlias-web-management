package com.jonathan.exception;

import com.jonathan.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global Exception Handler
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//capture all exceptions
    public Result exception(Exception e) {
        e.printStackTrace();
        return Result.error("Sorry, the operation failed, please contact the administrator!");
    }
}
