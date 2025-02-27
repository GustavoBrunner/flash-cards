package com.biblioteca.flash_cards.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserDTO(
        Long id,
        @NotBlank(message = "O e-mail não pode estar em branco.")
        @Email(message = "Formato de e-mail inválido.")
        String email,
        @NotBlank(message = "O nome de usuário não pode estar em branco.")
        @Size(min = 3, max = 20, message = "O nome de usuário deve ter entre 3 e 20 caracteres.")
        String username,
        @NotBlank
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "A senha deve ter pelo menos 8 caracteres, incluindo uma letra maiúscula, uma letra minúscula, um número e um caractere especial.")
        String password
) {
}
