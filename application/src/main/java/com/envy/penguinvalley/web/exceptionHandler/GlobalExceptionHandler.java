package com.envy.penguinvalley.web.exceptionHandler;

import com.envy.penguinvalley.exception.NoPenguinPresent;
import com.envy.penguinvalley.web.controller.ControllerEsempio;
import com.envy.penguinvalley.web.controller.GestioneServiziController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.Locale;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoPenguinPresent.class)
    public ResponseEntity<?> noPenfuinPresentException(NoPenguinPresent ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setDate(new Date());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatusCode((HttpStatus.BAD_REQUEST.value()));
        errorResponse.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
/*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setDate(new Date());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatusCode((HttpStatus.BAD_REQUEST.value()));
        errorResponse.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
 */

}
