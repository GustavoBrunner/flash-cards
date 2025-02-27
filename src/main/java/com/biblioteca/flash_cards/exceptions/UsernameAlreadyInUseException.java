package com.biblioteca.flash_cards.exceptions;

public class UsernameAlreadyInUseException extends RuntimeException {
    public UsernameAlreadyInUseException() {
        super("Nome de usuário já está em uso!");
    }

    public UsernameAlreadyInUseException(String message) {
        super(message);
    }
}
