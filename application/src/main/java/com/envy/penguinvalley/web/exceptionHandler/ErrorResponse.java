package com.envy.penguinvalley.web.exceptionHandler;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorResponse{
    private Date date;
    private int statusCode;
    private String error;
    private String message;
}
