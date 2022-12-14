package com.rollthedice.commons.utils.exceptions;

import com.rollthedice.commons.utils.exceptions.datanotfound.DataNotFoundException;
import com.rollthedice.commons.utils.exceptions.errorobject.ErrorObject;
import com.rollthedice.commons.utils.exceptions.errorobject.ErrorResponse;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(exception.getBindingResult().getFieldErrors().stream()
                        .map((FieldError fieldError) -> ErrorObject.builder()
                                .message(fieldError.getDefaultMessage())
                                .field(fieldError.getField())
                                .parameter(exception.getClass().getSimpleName())
                                .build()).toList())
                .build();
    }
    
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleDataNotFoundException(DataNotFoundException exception){
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message("Data not found")
                        .field(exception.getMessage())
                        .parameter(exception.getClass().getSimpleName())
                        .build()))
                .build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(NoSuchElementException exception){
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(BAD_REQUEST.name())
                        .field(exception.getMessage())
                        .parameter(exception.getClass().getSimpleName())
                        .build()))
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception exception){
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(INTERNAL_SERVER_ERROR.name())
                        .field(exception.getMessage())
                        .parameter(exception.getClass().getSimpleName())
                        .build()))
                .build();
    }
}
