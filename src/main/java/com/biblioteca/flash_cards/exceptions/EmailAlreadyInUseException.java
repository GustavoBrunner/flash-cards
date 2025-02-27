package com.biblioteca.flash_cards.exceptions;

public class EmailAlreadyInUseException extends RuntimeException {
    public EmailAlreadyInUseException() {
        super("E-mail já cadastrado!");
    }

    public EmailAlreadyInUseException(String message) {
        super(message);
    }
}
