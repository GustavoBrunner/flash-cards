package com.biblioteca.flash_cards.infra;

import com.biblioteca.flash_cards.exceptions.EmailAlreadyInUseException;
import com.biblioteca.flash_cards.exceptions.UserNotFoundException;
import com.biblioteca.flash_cards.exceptions.UsernameAlreadyInUseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(UsernameAlreadyInUseException.class)
    public ResponseEntity<String> usernameAlreadyInUseExceptionHandler(UsernameAlreadyInUseException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome de usuário já está em uso!!");
    }

    @ExceptionHandler(EmailAlreadyInUseException.class)
    public ResponseEntity<String> emailAlreadyInUseHandler(EmailAlreadyInUseException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("E-mail já cadastrado!");
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFoundHandler(UserNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
    }
}