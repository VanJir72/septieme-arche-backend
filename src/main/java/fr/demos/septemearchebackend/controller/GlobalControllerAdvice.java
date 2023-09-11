package fr.demos.septemearchebackend.controller;

import
fr.demos.septemearchebackend.exceptions.ApiError;
import fr.demos.septemearchebackend.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ApiError> NotFoundExceptionHandler(NotFoundException ex) {
        return new ResponseEntity<>(new ApiError(404, ex.getMessage()),
                HttpStatus.NOT_FOUND);
    }

}
