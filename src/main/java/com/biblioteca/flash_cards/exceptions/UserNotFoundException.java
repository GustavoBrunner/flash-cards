package com.biblioteca.flash_cards.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Usuário não encontrado!");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
