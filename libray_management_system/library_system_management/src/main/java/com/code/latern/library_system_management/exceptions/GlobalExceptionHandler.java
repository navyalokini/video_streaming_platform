package com.code.latern.library_system_management.exceptions;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
     @ExceptionHandler(DuplicateTitleExecption.class)
    public ResponseEntity<?> DuplicateTitleHandler(Exception ex){
        return new ResponseEntity<>("Duplicate title has been encountered", HttpStatusCode.valueOf(200));
    }
    @ExceptionHandler(TitleNotFound.class)
    public ResponseEntity<?> bookTitleNotFound(Exception ex){
         return new ResponseEntity<>("Book with provided title does'nt exist",HttpStatusCode.valueOf(200));
    }
}
