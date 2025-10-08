package com.mecaps.socialApp.exception;


import lombok.Data;

import java.time.LocalDateTime;

import java.time.LocalDateTime;

// NotFound
// UserExists

@Data
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;


    public ErrorResponse(LocalDateTime timestamp, int status, String error, String message, String path){
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }



}

