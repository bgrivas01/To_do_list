package com.example.demo;

import java.time.LocalDateTime;

public class ErrorResponse {
    
    private String message; //this would be the actual error message
    private int status; //status code like 404, etc
    private LocalDateTime timestamp; //when the error happened

    public ErrorResponse(String message, int status){
        this.message = message; 
        this.status = status;
        this.timestamp = LocalDateTime.now(); //sets the time automatically to the time of the error
    }

    public String getMessage(){
        return message;
    }

    public int getStatus(){
        return status; 
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setStatus(int status){
        this.status = status; 
    }

    public void setTimeStamp(LocalDateTime timestamp){
        this.timestamp = timestamp;
}
}