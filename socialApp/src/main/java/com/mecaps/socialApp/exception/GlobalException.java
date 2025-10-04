package com.mecaps.socialApp.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import  com.mecaps.socialApp.exception.ErrorResponse;
import com.mecaps.socialApp.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(com.mecaps.socialApp.exception.UserNotFoundException.class)
    public ResponseEntity<com.mecaps.socialApp.exception.ErrorResponse> hadleUserNotFound(
            com.mecaps.socialApp.exception.UserNotFoundException exception, HttpServletRequest request)

    {


        com.mecaps.socialApp.exception.ErrorResponse errorResponse =
                new com.mecaps.socialApp.exception.ErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.NOT_FOUND.value(),
                        exception.getMessage(),
                        request.getRequestURI()
                );
        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(404));
    }


























//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException ex, HttpServletRequest request) {
//        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI());
//
//    }
//
//
//    private ResponseEntity<ErrorResponse> buildResponse(HttpStatus status, String message, String path) {
//        ErrorResponse errorResponse = new ErrorResponse(
//                LocalDateTime.now(),
//                status.value(),
//                status.getReasonPhrase(),
//                message,
//                path
//
//        );
//        return new ResponseEntity<>(errorResponse, status);
//    }


}